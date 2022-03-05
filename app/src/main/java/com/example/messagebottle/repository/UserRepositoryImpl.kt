package com.example.messagebottle.repository

import android.content.Context
import android.util.Log
import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.data.model.mapToPresentation
import com.example.messagebottle.data.remote.UserApi
import com.example.messagebottle.ui.item.UserItem
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserRepositoryImpl(private val userApi: UserApi) : UserRepository {

    private val db = Firebase.firestore
    val TAG = "UserRepositoryImpl"
    override suspend fun getUserRepository(user_email : String, context : Context): UserItem? {
        val result = userApi.getUser(user_email)
        if(result == null) {
            return result
        }
        else {
            return result.mapToPresentation(context)
        }
    }

    override suspend fun setUserRepository(user : UserItem): Boolean {
        Log.d(TAG, "setUserRepository 실행")
        return userApi.setUser(user)
    }
}