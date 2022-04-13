package com.zarisa.bankaccountmanagement

import android.content.Context
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

    fun getAccounts() : List<UserAccount>{
        return db!!.accountDao().getAll()
    }
    fun insertAccount(account: UserAccount){
        AccountDao?.insert(account)
    }

}