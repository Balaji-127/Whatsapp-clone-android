package com.example.whatsapp.ui.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.databinding.FragmentChatsBinding
import com.example.whatsapp.model.User

class ChatFragment : Fragment(R.layout.fragment_chats) {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    private lateinit var favouriteChatsAdapter: FavouriteChatsAdapter
    private lateinit var chatAdapter: UserChatAdapter


    private val users = mutableListOf<User>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChatsBinding.bind(view)

        fillDummyUser()

        setupRecyclerViews()

    }

    private fun setupRecyclerViews() {
        favouriteChatsAdapter = FavouriteChatsAdapter().also { it.users = users }
        chatAdapter = UserChatAdapter().also { it.users = users }

        binding.apply {

            rvChats.apply {
                adapter = chatAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }

            rvFavouriteContacts.apply {
                adapter = favouriteChatsAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
            }


        }


    }

    private fun fillDummyUser() {
        for (i in 1..10) {
            users.add(
                User(
                    i.toLong(),
                    "Example Name",
                    "https://img.favpng.com/12/15/21/computer-icons-avatar-user-profile-recommender-system-png-favpng-HaMDUPFH1etkLCdiFjgTKHzAs.jpg",
                    "This is the last message from this user",
                    "14:35"
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}