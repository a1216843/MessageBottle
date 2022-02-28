package com.example.messagebottle.repository

import com.example.messagebottle.data.model.UserModel

interface UserRepository {
    fun getUserRepository() : UserModel
}