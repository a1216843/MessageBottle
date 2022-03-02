package com.example.messagebottle.ui.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.example.messagebottle.repository.MessageRepository

class WriteViewModel(private val messageRepository: MessageRepository) {
    val isLoading = ObservableField(false)
    val enabledSendButton = ObservableField(true)
    val errorMessage = ObservableField("")
    val editMessageText = ObservableField("")
    init {
        editMessageText.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                val message = editMessageText.get()
                if(message.isNullOrEmpty()) {
                    enabledSendButton.set(false)
                }
                else {
                    enabledSendButton.set(true)
                }
            }
        })
    }

}