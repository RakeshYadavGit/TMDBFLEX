package com.rawenginerring_.tmdbflexapp_.activity_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.rawenginerring_.tmdbflexapp_.MainActivity
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.activity_.Authentication.SignINActivity
import com.rawenginerring_.tmdbflexapp_.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(mBinding.root)
        supportActionBar!!.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            val account = GoogleSignIn.getLastSignedInAccount(this)
            if (account != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, SignINActivity::class.java)
                startActivity(intent)
            }

            finish()

        }, 2000)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}