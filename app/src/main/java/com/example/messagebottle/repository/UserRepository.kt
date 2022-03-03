package com.example.messagebottle.repository

import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.data.remote.UserApi

interface UserRepository {
    fun getUserRepository() : UserModel
}