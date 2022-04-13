package com.zarisa.bankaccountmanagement

import android.accounts.Account
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.zarisa.bankaccountmanagement.data_base.UserAccount

class SharedViewModel(app: Application) : AndroidViewModel(app){

    var number = MutableLiveData (0)
    private lateinit var  questionList : List<UserAccount>
    var question  = MutableLiveData<UserAccount> ()
    init{
        Repository.initDB(app.applicationContext)
        questionList = Repository.getAccounts()
        question.value = questionList[0]
    }
    fun nextQuestion() {
        // check if (question nu,ber is in range)
        number.value = number.value?.plus(1)
        number.value?.let{ number ->
            question.value = questionList[number]
        }
    }

    fun addAccount(cardNumber: Int, accountType: String, credit: Int) {
        Repository.insertAccount(UserAccount(cardNumber,accountType,credit))
    }


}