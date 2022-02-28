package com.example.messagebottle.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.messagebottle.R
import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.data.model.mapToPresentation
import com.example.messagebottle.data.remote.ApiProvider.UserApi
import com.example.messagebottle.databinding.ActivityMainBinding
import com.example.messagebottle.ui.item.UserItem
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var user_info : UserItem? = null
    var result : UserModel? = null
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.Main).launch {
            var result = UserApi.getUser("Test_User")
            initUserInfo(result, baseContext)
            System.out.println("테테테테스스스스트트트트 : ${user_info?.name}")
        }
    }
    fun initUserInfo(info : UserModel?, context: Context) {
        System.out.println("테스트 info : ${info?.name}")
        user_info = info?.mapToPresentation(context)
        System.out.println("테스트 : ${user_info?.name}")
    }
}
