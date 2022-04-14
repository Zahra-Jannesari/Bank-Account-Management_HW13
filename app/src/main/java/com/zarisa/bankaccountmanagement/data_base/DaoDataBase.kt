package com.zarisa.bankaccountmanagement.data_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface AccountDao {
    @Query("SELECT * FROM UserAccount")
    fun getAll(): LiveData<List<UserAccount>>
    @Query("SELECT * FROM UserAccount where cardNumber=:cardNumber")
    fun getAccount(cardNumber: Int): LiveData<UserAccount>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg userAccount: UserAccount)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userAccount: UserAccount)

    @Delete
    fun delete(userAccount: UserAccount)
    @Delete
    fun deleteAll(userAccounts: List<UserAccount>?)

}