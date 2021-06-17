package id.ramli.movie_jetpack_app.data.source.tv_show

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by ramliy10 on 02/05/21.
 */
@Entity(tableName = "tb_tvShow")
@Parcelize
data class TvShowEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "tvShowId")
    var tvShowId: Int? = 0,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "poster")
    var poster: String? = null,
    @ColumnInfo(name = "release")
    var release: String? = null,
    @ColumnInfo(name = "rating")
    var rating: String? = null,
    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable