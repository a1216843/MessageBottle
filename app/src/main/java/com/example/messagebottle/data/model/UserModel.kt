package com.example.messagebottle.data.model

import android.content.Context
import com.example.messagebottle.R
import com.example.messagebottle.ui.item.UserItem

data class UserModel(
    val uid : String = "",
    val name : String = "",
    val age : Int = 0,
    @field:JvmField
    val sex : Boolean = true,
    val location : String = "",
    val interest : ArrayList<String>? = null,
    val profileImg : String = ""
)

fun UserModel.mapToPresentation(context: Context) = UserItem(
    name = name,
    age = age,
    sex = if(sex) context.resources.getString(R.string.sex_is_man)
    else context.resources.getString(R.string.sex_is_male),
    location = location,
    interest = (interest ?: "관심사 없음") as ArrayList<String>,
    profileImg = profileImg
)