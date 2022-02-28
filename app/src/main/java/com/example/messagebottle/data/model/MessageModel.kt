package com.example.messagebottle.data.model

import android.content.Context
import com.example.messagebottle.R
import com.example.messagebottle.ui.item.MessageItem
import com.example.messagebottle.utils.DateUtils
import java.lang.IllegalArgumentException

data class MessageModel(
    val send_user : String,
    val send_date : String,
    val message : String,
    val receive_user: String?,
    val receive_uid : String,
    val image_url : String
)

fun MessageModel.mapToPresentation(context: Context) = MessageItem(
    send_user = send_user,
    send_date = try {
        DateUtils.dateFormatToShow.format(send_date)
    } catch (e : IllegalArgumentException) {
        context.resources.getString(R.string.unknown_date)
    },
    message = message,
    receive_user = receive_user?:context.resources.getString(R.string.unknown_receive_user),
    receive_uid = receive_uid,
    image_url = image_url
)