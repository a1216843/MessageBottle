package com.example.messagebottle.repository

import android.content.Context
import com.example.messagebottle.data.model.MessageModel
import com.example.messagebottle.ui.item.MessageItem

interface MessageRepository {
    suspend fun getMessageRepository(user_email : String, flag : Int, context: Context) : ArrayList<MessageItem>?
    suspend fun setMessageRepository(message : MessageItem) : Boolean
}