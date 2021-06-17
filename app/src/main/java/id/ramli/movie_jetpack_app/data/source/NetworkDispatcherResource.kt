package id.ramli.movie_jetpack_app.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class NetworkDispatcherResource<Result, Request> {

    private val resultData = MediatorLiveData<DefaultResourceStatus<Result>>()

    init {
        resultData.value = DefaultResourceStatus.loading(null)

        @Suppress("LeakingThis")
        val dbLocalSource = loadDataFromDB()

        resultData.addSource(dbLocalSource) { data ->
            resultData.removeSource(dbLocalSource)
            if (shouldFetchData(data)) {
                fetchDataFromNetwork(dbLocalSource)
            } else {
                resultData.addSource(dbLocalSource) { data ->
                    resultData.value = DefaultResourceStatus.success(data)
                }
            }
        }
    }

    private fun onFetchFailed() {}

    protected abstract fun loadDataFromDB(): LiveData<Result>

    protected abstract fun shouldFetchData(data: Result?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<Request>>

    protected abstract fun saveDataCallResult(data: Request)

    private fun fetchDataFromNetwork(dbSource: LiveData<Result>) {
        val apiResponse = createCall()

        resultData.addSource(dbSource) { newData ->
            resultData.value = DefaultResourceStatus.loading(newData)
        }
        resultData.addSource(apiResponse) { response ->
            resultData.removeSource(apiResponse)
            resultData.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS ->
                    CoroutineScope(Dispatchers.IO).launch {
                        response.body?.let { saveDataCallResult(it) }
                        Log.d("SUCESS  : ", response.status.name)

                        withContext(Dispatchers.Main) {
                            resultData.addSource(loadDataFromDB()) { data ->
                                resultData.value = DefaultResourceStatus.success(data)
                            }
                        }

                    }

                StatusResponse.ERROR -> {
                    onFetchFailed()
                    Log.d("ERROR : ", response.status.name)
                    resultData.addSource(dbSource) { data ->
                        resultData.value = DefaultResourceStatus.error(response.message, data)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<DefaultResourceStatus<Result>> = resultData
}