package com.example.messagebottle.data.remote

import android.util.Log
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
    suspend fun getRandomUser() : String {
        var result = ""
        return try {
            db.collection("User").whereGreaterThanOrEqualTo("random_id", 0)
                .orderBy("random")
                .limit(1)
                .get()
                .addOnSuccessListener {
                    if(it.isEmpty!!) {
                        for(document in it) {
                            result = document.toObject<UserModel>().email
                        }
                    }
                }.await()
            return result
        } catch (e : FirebaseException) {
            Log.d(TAG, "Error : getRandomUser / ${e.message}")
            return result
        }
    }
}