package com.example.messagebottle.ui.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.messagebottle.data.remote.ApiProvider
import com.example.messagebottle.databinding.FragmentWriteBinding
import com.example.messagebottle.repository.MessageRepository
import com.example.messagebottle.repository.MessageRepositoryImpl
import com.example.messagebottle.ui.viewmodel.WriteViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
// UserFragment로부터 수신자의 UID가 넘어왔다면 1번, 아니라면 2번
// 1. 친구에게 보내는 편지
// 2. 불특정 사용자에게 보내는 편지
// 3. 편지 작성 및 사진 등록
class WriteFragment : Fragment() {
    lateinit var binding: FragmentWriteBinding
    companion object {
        fun newInstance() = WriteFragment()
    }
    private val messageRepository : MessageRepository = MessageRepositoryImpl(ApiProvider.UserApi, ApiProvider.MessageApi)

    // TODO : ViewModel Factory 사용해서 생성하는 것으로 변경할 것
    private val writeModel by lazy {
        WriteViewModel(messageRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun initEditText() {
        binding
    }

}