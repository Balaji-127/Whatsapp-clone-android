package com.example.whatsapp.model

data class User(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val latestMessage: String,
    val latestMessageTime: String
)