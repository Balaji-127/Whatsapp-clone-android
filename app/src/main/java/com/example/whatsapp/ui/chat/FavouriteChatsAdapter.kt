package com.example.whatsapp.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.databinding.LayoutFavoruiteContactBinding
import com.example.whatsapp.model.User

class FavouriteChatsAdapter : RecyclerView.Adapter<FavouriteChatsAdapter.FavouriteViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var users: List<User>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val binding = LayoutFavoruiteContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FavouriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }


    class FavouriteViewHolder(private val binding: LayoutFavoruiteContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.apply {

                Glide.with(binding.root)
                    .load(user.imageUrl)
                    .circleCrop()
                    .into(ivFavImage)

                tvFavName.text = user.name

            }

        }

    }

}