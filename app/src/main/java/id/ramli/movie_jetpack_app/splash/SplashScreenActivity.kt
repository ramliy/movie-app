package id.ramli.movie_jetpack_app.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import id.ramli.movie_jetpack_app.databinding.ActivitySplashScreenBinding
import id.ramli.movie_jetpack_app.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activitySplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(activitySplashScreenBinding.root)
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler(mainLooper).postDelayed({
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },1500)
    }
}