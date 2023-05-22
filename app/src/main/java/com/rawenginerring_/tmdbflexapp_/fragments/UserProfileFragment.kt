package com.rawenginerring_.tmdbflexapp_.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.SignInAccount
import com.google.android.gms.common.api.GoogleApiClient
import com.rawenginerring_.tmdbflexapp_.R
import com.rawenginerring_.tmdbflexapp_.activity_.Authentication.SignINActivity
import com.rawenginerring_.tmdbflexapp_.databinding.FragmentUserProfileBinding


class UserProfileFragment : Fragment() {
    private lateinit var mBinding: FragmentUserProfileBinding
    private lateinit var mGoogleApiClient: GoogleApiClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentUserProfileBinding.inflate(inflater,container,false)

        val account = GoogleSignIn.getLastSignedInAccount(requireContext())
        if (account != null) {
            val userName = account.displayName
            val userEmail = account.email
            val userProfile = account.photoUrl
            val userFamily = account.familyName

            if (userProfile != null) {
                Glide.with(this)
                    .load(userProfile)
                    .into(mBinding.userImageView)
            } else {
                Glide.with(this)
                    .load(R.drawable.people)
                    .into(mBinding.userImageView)
            }
            mBinding.userNameProfileView.text = userName
            mBinding.userGender.text = "Male"
            mBinding.userEmailId.text = userEmail

        } else {
            Toast.makeText(requireContext(),"Something went wrong!",Toast.LENGTH_SHORT).show()
        }

        mBinding.logout.setOnClickListener {
            val googleSignInClient = GoogleSignIn.getClient(requireContext(), GoogleSignInOptions.DEFAULT_SIGN_IN)
            googleSignInClient.signOut().addOnCompleteListener(requireActivity()) {
                startActivity(Intent(requireContext(), SignINActivity::class.java))
                requireActivity().finish()
            }

        }

        return mBinding.root
    }

}
