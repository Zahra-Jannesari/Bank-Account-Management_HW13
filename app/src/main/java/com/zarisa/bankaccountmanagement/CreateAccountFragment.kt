package com.zarisa.bankaccountmanagement

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.zarisa.bankaccountmanagement.data_base.UserAccount
import com.zarisa.bankaccountmanagement.databinding.FragmentCreateAccountBinding


class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding
    private val profileSharePref: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(
            "user Information",
            Context.MODE_PRIVATE
        )
    }
    private val viewModel: SharedViewModel by activityViewModels()
    var i = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.numberOfUserAccounts=profileSharePref.getString(accountNumber,"0")?.toInt()
        binding.textViewRemainAccount.text = "تعداد حساب ثبت نشده:${viewModel.numberOfUserAccounts}"
        binding.buttonSaveChange.setOnClickListener { saveData() }
    }

    private fun saveData() {
        if (validateData()) {
            var remainedAccount = viewModel.numberOfUserAccounts?.minus(i)
            binding.textViewRemainAccount.text = "تعداد حساب ثبت نشده:${remainedAccount}"
            viewModel.addAccount(
                binding.EditTextCardNumber.text.toString().toInt(),
                binding.EditTextAccountType.text.toString(),
                binding.EditTextCredit.text.toString().toInt()
            )
            if (remainedAccount == 0) {
                binding.buttonSaveChange.isEnabled = false
                return
            }
            i++
        } else
            Toast.makeText(
                requireContext(),
                "لطفا تمامی اطلاعات را بطور صحیح تکمیل کنید.",
                Toast.LENGTH_SHORT
            ).show()
    }

    private fun validateData(): Boolean {
        var areAllDataValid = true
        binding.EditTextCredit.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
        }
        binding.EditTextAccountType.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
        }
        binding.EditTextCardNumber.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
        }
        return areAllDataValid
    }
}