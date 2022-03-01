package com.example.messagebottle.data.model

import android.content.Context
import com.example.messagebottle.ui.item.FriendItem

data class FriendModel(
    val uid : String = "",
    val name : String = "",
    val age : Int = 0,
    val location : String = "",
    val interest : String = "",
    val message_cnt : Int = 0
)

fun FriendModel.mapToPresentation(context: Context) = FriendItem (
    uid = uid,
    name = name,
    age = age,
    location = location,
    interest = interest,
    message_cnt = message_cnt
        )