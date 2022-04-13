package com.zarisa.bankaccountmanagement.data_base

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserAccount(
    @PrimaryKey val cardNumber: Int,
    val type: String,
    val credit: Int
)