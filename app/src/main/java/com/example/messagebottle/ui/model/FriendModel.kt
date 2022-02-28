package com.example.messagebottle.ui.model

import android.content.Context

data class FriendModel(
    val uid : String,
    val name : String,
    val age : Int,
    val location : String,
    val interest : String,
    val message_cnt : Int
)

fun FriendModel.mapToPresentation(context: Context) = FriendItem (
    uid = uid,
    name = name,
    age = age,
    location = location,
    interest = interest,
    message_cnt = message_cnt
        )