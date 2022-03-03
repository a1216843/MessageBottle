package com.example.messagebottle.ui.viewmodel

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.messagebottle.repository.UserRepository
import com.example.messagebottle.ui.TAG
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun onSignInResult(result : FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if(result.resultCode == AppCompatActivity.RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            Log.d(TAG, "로그인 성공 : ${user?.email}")
            // 사용자 등록하기
            editProfileUser(user)
        }
        else {
            Log.d(TAG, "로그인 실패 : ${response?.error}")
        }
    }

    private fun editProfileUser(user : FirebaseUser?) {
        // db.collection("User")에 이메일이 등록되어있는지 확인, 등록되어있다면 함수 종료
        // 등록되어있지 않다면 프로필 작성해서 UserRepository의 setUser 사용해서 등록

    }
}