package com.zarisa.bankaccountmanagement.data_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface AccountDao {
    @Query("SELECT * FROM UserAccount")
    fun getAll(): LiveData<List<UserAccount>>
    @Query("SELECT * FROM UserAccount where cardNumber IN (:cNumber)")
    fun getAccount(cNumber: Int): LiveData<UserAccount>
    @Query("Select count(*) From UserAccount")
    fun countOfAccounts():LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg userAccount: UserAccount)

    @Delete
    fun delete(userAccount: UserAccount)
    @Delete
    fun deleteAll(userAccounts: List<UserAccount>?)

}