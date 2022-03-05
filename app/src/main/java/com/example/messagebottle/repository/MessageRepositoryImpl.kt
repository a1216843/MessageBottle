package com.example.messagebottle.repository

import android.content.Context
import com.example.messagebottle.data.model.mapToPresentation
import com.example.messagebottle.data.remote.MessageApi
import com.example.messagebottle.data.remote.UserApi
import com.example.messagebottle.ui.item.MessageItem

class MessageRepositoryImpl(private val userApi: UserApi, private val messageApi : MessageApi) : MessageRepository{
    override suspend fun getMessageRepository(user_email: String, flag: Int, context: Context): ArrayList<MessageItem>? {
        // 수신자가 편지 확인할 때 사용
        // messageApi 사용해서 가져오기
        // flag는 Message_Send에서 가져올 것인지, Message_Receive에서 가져올 것인지, Message_Stored에서 가져올 것인지 구분함
        val messages = messageApi.getMessage(user_email, flag)
        val result : ArrayList<MessageItem>? = null
        if (messages != null) {
            for(message in messages) {
                result?.add(message.mapToPresentation(context))
            }
        }
        return result

    }
    override suspend fun setMessageRepository(message : MessageItem): Boolean {
        // 발신자가 편지를 전송할 때 사용
        // messageApi 사용해서 서버에 등록하기
        // UserRepository의 setUser를 구현할 필요 없이 그냥 userApi.setUser를 여기서 사용하면 된다.
        return messageApi.setMessage(message, userApi.getRandomUser())
    }
}