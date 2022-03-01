package com.example.messagebottle.ui.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messagebottle.databinding.FragmentUserBinding

// 1. 사용자 프로필 관리
// 2. MessageBottle을 통해 등록한 Friends List (RecyclerView 사용)
// 3. Friend 클릭하면 대상에게 편지 보내기(WriteFragment 실행)

class UserFragment : Fragment() {
    lateinit var binding : FragmentUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = UserFragment()
    }
}