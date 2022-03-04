package com.example.messagebottle.data.remote

import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.ui.item.UserItem
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class UserApi {
    private val db = Firebase.firestore
    val TAG = "UserApi"

    suspend fun getUser(user : String): UserModel? {
        var result : UserModel? = null
       return try {
           db.collection("User").document(user)
               .get().addOnSuccessListener {
                   result = it.toObject<UserModel>()
                   System.out.println("데이터 읽어옴 : ${it.data}")
               }.await()
           result
       } catch (e : FirebaseException) {
           System.out.println(e.message)
           result
       }
    }
    suspend fun setUser(user : UserItem) : Boolean {
        var result = false
        return try {
            db.collection("User").document(user.email).set(user)
                .addOnSuccessListener {
                    result = true
                }.await()
            result
        } catch (e : FirebaseException) {
            result
        }
    }
}