package com.example.messagebottle.repository

import com.example.messagebottle.data.model.MessageModel
import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.data.remote.MessageApi
import com.example.messagebottle.data.remote.UserApi

abstract class MessageRepositoryImpl(private val userApi: UserApi, private val messageApi : MessageApi) : MessageRepository, UserRepository{
    override fun getMessageRepository(): MessageModel {
        // 수신자가 편지 확인할 때 사용
        // messageApi 사용해서 가져오기
        TODO("Not yet implemented")
    }
    override fun setMessageRepository(): Boolean {
        // 발신자가 편지를 전송할 때 사용
        // messageApi 사용해서 서버에 등록하기
        TODO("Not yet implemented")
    }
    override fun getUserRepository(): UserModel {
        // userApi 이용해서 발신자 계정 정보 가져오기
        // userApi 사용해서 가져오기
        TODO("Not yet implemented")
    }
}