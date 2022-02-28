package com.example.messagebottle.ui.model

data class MessageItem(
    val send_user : String,
    val send_date : String,
    val message : String,
    val receive_user: String,
    val receive_uid : String,
    val image_url : String
)
