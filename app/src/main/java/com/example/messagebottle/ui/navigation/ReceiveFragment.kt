package com.example.messagebottle.ui.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messagebottle.R
import com.example.messagebottle.databinding.FragmentReceiveBinding


// 1. 나에게 도착한 편지 List 확인 (RecyclerView 사용)
// 2. 편지를 보낸 이의 이름, 나이, 취미 등의 대략적인 정보를 통해 편지를 수신할지 패스할지 결정
// 3. 수신 및 답장시 발신자에게 FCM 푸시알림 전송

class ReceiveFragment : Fragment() {
    lateinit var binding : FragmentReceiveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReceiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = ReceiveFragment()
    }
}