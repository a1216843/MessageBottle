package com.example.messagebottle.data.remote

import android.content.Context
import android.util.Log
import com.example.messagebottle.data.model.MessageModel
import com.example.messagebottle.data.model.mapToPresentation
import com.example.messagebottle.ui.item.MessageItem
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MessageApi {
    // 일반적인 보내기 함수와 답장 함수 구현
    private val db = Firebase.firestore
    val TAG = "MessageApi"

    suspend fun getMessage(user_email : String, flag : Int) : List<MessageModel>? {
        var result : ArrayList<MessageModel>? = null
        var route = ""
        when(flag) {
            0 ->
                route = "Message_Send"
            1 ->
                route = "Message_Receive"
            2 ->
                route = "Message_Stored"
            else ->
                Log.d(TAG, "Error : flag argument is wrong number")
        }
        return try {
            if(route == "") {
                return null
            }
            db.collection("User").document(user_email).collection(route)
                .get().addOnSuccessListener {
                    for (document in it) {
                        result?.add(document.toObject())
                    }
                }.await()
            return result
        } catch (e : FirebaseException) {
            Log.d(TAG, "Error : getSendMessage / ${e.message}")
            return null
        }
    }

    suspend fun setMessage(message : MessageItem, user : String) : Boolean {
        var result = false
        db.collection("User").document(user).collection("Message_Send")
            .add(message)
            .addOnSuccessListener {
                result = true
            }
        return result
    }
}