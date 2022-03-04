package com.example.messagebottle.ui.viewmodel

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.messagebottle.repository.UserRepositoryImpl
import com.example.messagebottle.ui.item.UserItem
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.SecureRandom


class LoginViewModel(private val userRepository: UserRepositoryImpl) : ViewModel() {

    private val db = Firebase.firestore
    val TAG = "LoginViewModel"
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
        db.collection("User").document(user?.email!!)
            .get()
            .addOnSuccessListener {
                if(it.data == null) {
                    Log.d(TAG, "No Such document")
                    val new_user = UserItem(
                        email = user?.email!!,
                        random_id = SecureRandom().nextInt(100000),
                        name = "테스트",
                        age = 123,
                        sex = "남자",
                        location = "우주",
                        interest = arrayListOf("아침", "점심", "저녁"),
                        profileImg = "이미지"
                    )
                    CoroutineScope(Dispatchers.Main).launch {
                        // progress bar on
                        val result = userRepository.setUserRepository(new_user)
                        // progress bar off
                        Log.d(TAG, "setUser 동기 호출 결과 : ${result.toString()}")
                    }
                }
                else {
                    Log.d(TAG, "DocumentSnapshot data : ${it.data}")
                }
            }
            .addOnFailureListener {
                Log.d(TAG, "get failed with : ", it)
            }
    }
}