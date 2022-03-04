package com.example.messagebottle.data.model

import android.content.Context
import com.example.messagebottle.R
import com.example.messagebottle.ui.item.UserItem

data class UserModel(
    val email : String = "",
    // random_id는 DB에서 문서를 랜덤으로 선택하기 위한 값으로 한 번 선택된 문서는 항상 random_id를 수정해주어야 한다.
    // random_id는 SecureRandom().nextInt(100000)으로 생성할 것
    val random_id : Int = 0,
    val name : String = "",
    val age : Int = 0,
    @field:JvmField
    val sex : Boolean = true,
    val location : String = "",
    val interest : ArrayList<String>? = null,
    val profileImg : String = ""
)

fun UserModel.mapToPresentation(context: Context) = UserItem(
    email = email,
    random_id = random_id,
    name = name,
    age = age,
    sex = if(sex) context.resources.getString(R.string.sex_is_man)
    else context.resources.getString(R.string.sex_is_male),
    location = location,
    interest = (interest ?: "관심사 없음") as ArrayList<String>,
    profileImg = profileImg
)