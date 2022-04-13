package com.zarisa.bankaccountmanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.zarisa.bankaccountmanagement.data_base.UserAccount
import com.zarisa.bankaccountmanagement.databinding.FragmentCreateAccountBinding


class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding
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
        binding.buttonSaveChange.setOnClickListener { saveData() }

    }

    private fun saveData() {
//        if (validateData()) {
            binding.textViewRemainAccount.text = "تعداد حساب ثبت نشده:${numberOfUserAccounts - i}"
            viewModel.addAccount(
                binding.EditTextCardNumber.text.toString().toInt(),
                binding.EditTextAccountType.text.toString(),
                binding.EditTextCredit.text.toString().toInt()
            )
//        }
    }

    private fun validateData(): Boolean {
        TODO("Not yet implemented")
    }
}