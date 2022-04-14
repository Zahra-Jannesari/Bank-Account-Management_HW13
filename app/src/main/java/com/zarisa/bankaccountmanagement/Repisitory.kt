package com.zarisa.bankaccountmanagement

import android.accounts.Account
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zarisa.bankaccountmanagement.data_base.UserAccount
import com.zarisa.bankaccountmanagement.data_base.AccountDao
import com.zarisa.bankaccountmanagement.data_base.AppDatabase

object Repository {
    var db : AppDatabase? = null
    var AccountDao  : AccountDao? = null

    fun initDB(context : Context){
        db = AppDatabase.getAppDataBase(context)

        AccountDao = db?.accountDao()

    }

    fun getAccounts() : LiveData<List<UserAccount>> {
        return db!!.accountDao().getAll()
    }
    fun insertAccount(account: UserAccount){
        AccountDao?.insert(account)
    }
    fun findSpecificAccount(cardNumber:Int):LiveData<UserAccount>?{
        return db?.accountDao()?.getAccount(cardNumber)
    }
    fun deleteAllAccounts(){
        AccountDao?.deleteAll(db!!.accountDao().getAll().value)
    }
}