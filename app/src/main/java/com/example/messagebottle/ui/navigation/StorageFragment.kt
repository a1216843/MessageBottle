package com.example.messagebottle.ui.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messagebottle.R
import com.example.messagebottle.databinding.FragmentStorageBinding

// 지금까지 교환한 편지를 사용자별로 구분하여 기록

class StorageFragment : Fragment() {
    lateinit var binding: FragmentStorageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStorageBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = StorageFragment()
    }
}