package com.example.messagebottle.ui.item

data class UserItem(
    val email : String,
    val name : String,
    val age : Int,
    val sex : String,
    val location : String,
    val interest : ArrayList<String>,
    val profileImg : String
)
