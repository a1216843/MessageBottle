package com.example.messagebottle.repository

import android.content.Context
import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.data.remote.UserApi
import com.example.messagebottle.ui.item.UserItem

interface UserRepository {
    suspend fun getUserRepository(user_email : String, context: Context) : UserItem?
    suspend fun setUserRepository(user : UserItem) : Boolean
}