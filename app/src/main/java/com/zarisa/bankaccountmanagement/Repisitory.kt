package com.zarisa.bankaccountmanagement

import android.accounts.Account
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zarisa.bankaccountmanagement.data_base.UserAccount
import com.zarisa.bankaccountmanagement.data_base.AccountDao
import com.zarisa.bankaccountmanagement.data_base.AppDatabase

object Repository {
    lateinit var accountDao  : AccountDao
    fun initDB(context : Context){
        accountDao = AppDatabase.getAppDataBase(context).accountDao()
    }
    fun getAccounts() : LiveData<List<UserAccount>> {
        return accountDao.getAll()
    }
    fun insertAccount(account: UserAccount){
        accountDao.insertAll(account)
    }
    fun findSpecificAccount(cardNumber:Int):LiveData<UserAccount>{
        return accountDao.getAccount(cardNumber)
    }
    fun deleteAllAccounts(){
        accountDao.deleteAll(accountDao.getAll().value)
    }
    fun countOfAccounts():LiveData<Int>{
        return accountDao.countOfAccounts()
    }
}