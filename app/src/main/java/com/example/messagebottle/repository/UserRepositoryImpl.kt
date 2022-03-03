package com.example.messagebottle.repository

import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.data.remote.UserApi

class UserRepositoryImpl(private val userApi: UserApi) : UserRepository {
    override fun getUserRepository(): UserModel {
        TODO("Not yet implemented")
    }

    fun setUserRepository(): Boolean {
        // 유저 등록할 때 사용
        TODO("Not yet implemented")
    }
}