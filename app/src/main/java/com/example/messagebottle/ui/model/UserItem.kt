package com.example.messagebottle.ui.model

data class UserItem(
    val name : String,
    val age : Int,
    val sex : String,
    val location : String,
    val interest : ArrayList<String>,
    val profileImg : String
)