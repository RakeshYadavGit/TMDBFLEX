package com.rawenginerring_.tmdbflexapp_.activity_.Authentication

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.rawenginerring_.tmdbflexapp_.MainActivity
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.databinding.ActivitySignInactivityBinding

class SignINActivity : AppCompatActivity(), OnCompleteListener<Void> {
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN: Int = 9001
    private lateinit var mBinding: ActivitySignInactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySignInactivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        supportActionBar?.apply {
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this@SignINActivity, R.color.colorPrimary)))
        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        mBinding.googleSign.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                updateUI(account)
            } catch (e: ApiException) {
                Log.w("TAG", "signInResult:failed code=" + e.statusCode)
                updateUI(null)
            }
        }
    }

    private fun updateUI(account: GoogleSignInAccount?) {
        if (account != null) {
            Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()
            val userName = account.displayName
            val userEmail = account.email
            val userProfile = account.photoUrl
            val userFamily = account.familyName
            startActivity(Intent(this@SignINActivity, MainActivity::class.java))
            finish()
            Log.d("TAG", "User Name: $userName")
            Log.d("TAG", "User Email: $userEmail")
            Log.d("TAG", "User Profile: $userProfile")
            Log.d("TAG", "User Family: $userFamily")
        } else {
            Toast.makeText(this, "Failed to log in", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onComplete(task: Task<Void>) {
        if (task.isSuccessful) {
            Toast.makeText(this, "Signed out successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Failed to sign out", Toast.LENGTH_SHORT).show()
        }
    }
}
