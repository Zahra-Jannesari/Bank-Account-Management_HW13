package com.zarisa.bankaccountmanagement

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    @PrimaryKey val accountNumber: Int,
    val type: String,
    val cardNumber: Int,
    val credit: Int
)