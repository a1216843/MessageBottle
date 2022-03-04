package com.example.messagebottle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.messagebottle.data.remote.ApiProvider
import com.example.messagebottle.databinding.ActivityLoginBinding
import com.example.messagebottle.repository.UserRepository
import com.example.messagebottle.repository.UserRepositoryImpl
import com.example.messagebottle.ui.viewmodel.LoginViewModel
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider


class LoginActivity : AppCompatActivity() {
    val TAG = "LoginActivity"
    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    // 로그인 Provider 등록
    val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())

    val signInIntent = AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .build()
    // 로그인 런처, 실행 결과는 ViewModel의 onSignInResult로 전달
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) {
            res -> loginViewModel.onSignInResult(res)
    }

    // Repository 생성
    private val userRepository : UserRepositoryImpl = UserRepositoryImpl(ApiProvider.UserApi)
    // ViewModel 생성
    private val loginViewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LoginViewModel(userRepository) as T
            }
        }).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 로그인 실행
        signInLauncher.launch(signInIntent)
    }

}