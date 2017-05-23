package org.lafzi.kotlinguideoffline.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import org.lafzi.kotlinguideoffline.R

class SplashActivity : AppCompatActivity() {

    companion object {
        @JvmStatic val SPLASH_TIME_OUT = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        openMainActivity()
    }

    private fun openMainActivity() {
        Handler().postDelayed({
            startActivity(Intent(this, NavigationActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
