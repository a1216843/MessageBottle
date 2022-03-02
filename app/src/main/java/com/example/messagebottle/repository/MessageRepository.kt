package com.example.messagebottle.repository

import com.example.messagebottle.data.model.MessageModel

interface MessageRepository {
    fun getMessageRepository() : MessageModel
    fun setMessageRepository() : Boolean
}