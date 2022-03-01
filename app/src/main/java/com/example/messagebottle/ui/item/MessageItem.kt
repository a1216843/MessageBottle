package com.example.messagebottle.ui.item

data class MessageItem(
    val message_uid : String,
    val send_user : String,
    val send_date : String,
    val message : String,
    val receive_user: String,
    val receive_uid : String,
    val image_url : String
)
