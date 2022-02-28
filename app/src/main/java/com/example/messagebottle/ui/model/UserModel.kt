package com.example.messagebottle.ui.model

import android.content.Context
import com.example.messagebottle.R

data class UserModel(
    val uid : String,
    val name : String,
    val age : Int,
    val sex : Boolean,
    val location : String,
    val interest : ArrayList<String>,
    val profileImg : String
)

fun UserModel.mapToPresentation(context: Context) = UserItem(
    name = name,
    age = age,
    sex = if(sex) context.resources.getString(R.string.sex_is_man)
    else context.resources.getString(R.string.sex_is_male),
    location = location,
    interest = interest,
    profileImg = profileImg
)