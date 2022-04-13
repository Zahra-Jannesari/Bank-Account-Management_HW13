package com.zarisa.bankaccountmanagement.data_base

import androidx.room.*

@Dao
interface AccountDao {
    @Query("SELECT * FROM Account")
    fun getAll(): List<Account>
    @Query("SELECT * FROM Account where cardNumber=:cardNumber")
    fun getAccount(cardNumber: Int): Account

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg account: Account)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: Account)

    @Delete
    fun delete(account: Account)

}