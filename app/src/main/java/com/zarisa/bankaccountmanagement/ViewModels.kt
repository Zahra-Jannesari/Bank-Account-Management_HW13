package com.zarisa.bankaccountmanagement

import android.accounts.Account
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zarisa.bankaccountmanagement.data_base.UserAccount

class SharedViewModel(app: Application) : AndroidViewModel(app) {
    var numberOfUserAccounts: Int? = 0
    var numberOfCurrentAccount = MutableLiveData(1)
    var accountsList: LiveData<List<UserAccount>>
    val currentAccountType = MutableLiveData<String>()
    val currentAccountCardNumber = MutableLiveData<Int>()
    val currentAccountCredit = MutableLiveData<Int>()

    val isNextAvailable = MutableLiveData(false)
    val isPrevAvailable = MutableLiveData(false)

    var question = MutableLiveData<UserAccount>()

    init {
        Repository.initDB(app.applicationContext)
        accountsList = Repository.getAccounts()
        setPrimaryData()
    }
    private fun setPrimaryData() {
        currentAccountType.value = accountsList.value?.get(0)?.type
        currentAccountCardNumber.value = accountsList.value?.get(0)?.cardNumber
        currentAccountCredit.value = accountsList.value?.get(0)?.credit
        if (numberOfUserAccounts!! > 1)
            isNextAvailable.value = true
    }

//    fun nextQuestion() {
//        // check if (question nu,ber is in range)
//        number.value = number.value?.plus(1)
//        number.value?.let{ number ->
//            question.value = questionList[number]
//        }
//    }

    fun addAccount(cardNumber: Int, accountType: String, credit: Int) {
        Repository.insertAccount(UserAccount(cardNumber, accountType, credit))
    }

    fun nextAccount() {
        numberOfCurrentAccount.value = numberOfCurrentAccount.value?.plus(1)
        numberOfCurrentAccount.value?.let { number ->
            updateData(number - 1)
        }
        checkNextPrev()
    }

    private fun updateData(number: Int) {
        currentAccountType.value = accountsList.value?.get(number)?.type
        currentAccountCardNumber.value = accountsList.value?.get(number)?.cardNumber
        currentAccountCredit.value = accountsList.value?.get(number)?.credit
    }

    fun prevAccount() {
        numberOfCurrentAccount.value = numberOfCurrentAccount.value?.minus(1)
        numberOfCurrentAccount.value?.let { number ->
            updateData(number - 1)
        }
        checkNextPrev()
    }


    private fun checkNextPrev() {
        isNextAvailable.value = when (numberOfCurrentAccount.value) {
            numberOfUserAccounts -> false
            else -> true
        }
        isPrevAvailable.value = when (numberOfCurrentAccount.value) {
            1 -> false
            else -> true
        }
    }
}