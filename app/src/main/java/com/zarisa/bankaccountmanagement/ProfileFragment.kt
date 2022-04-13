package com.zarisa.bankaccountmanagement

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.zarisa.bankaccountmanagement.databinding.FragmentProfileBinding

const val userName = "name"
const val lastName = "lastname"
const val father = "fatherName"
const val zipCode = "zipCode"
const val phoneNumber = "phone"
const val accountNumber="account"

var editTime = false

class ProfileFragment : Fragment() {
    private val profileSharePref: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(
            "user Information",
            Context.MODE_PRIVATE
        )
    }
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        choseCorrectFragment()
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun choseCorrectFragment() {
        if (profileSharePref.getString(userName, "") != "" && !editTime)
            findNavController().navigate(R.id.action_profileFragment_to_viewProfileFragment)
        else return
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        putDataInEditTexts()
        initViews()
    }

    private fun initViews() {
//        val inputText = outlinedTextField.editText?.text.toString()
//
//        outlinedTextField.editText?.doOnTextChanged { inputText, _, _, _ ->
//            // Respond to input text change
//        }
        binding.saveChangeButton.setOnClickListener { saveEditTextsData() }
    }

    private fun saveEditTextsData() {
        if (validateData()) {
            editTime = false
            saveData()
            findNavController().navigate(R.id.action_profileFragment_to_viewProfileFragment)
        } else
            Toast.makeText(
                requireContext(),
                "لطفا تمامی اطلاعات را بطور صحیح تکمیل کنید.",
                Toast.LENGTH_SHORT
            ).show()
    }

    private fun saveData() {
        val editor = profileSharePref.edit()
        editor.putString(userName, binding.EditTextUserName.text.toString())
        editor.putString(lastName, binding.EditTextUserLastname.text.toString())
        editor.putString(father, binding.EditTextUserFatherName.text.toString())
        editor.putString(zipCode, binding.EditTextUserZipCode.text.toString())
        editor.putString(phoneNumber, binding.EditTextUserPhoneNumber.text.toString())
        editor.putString(accountNumber,binding.EditTextUserAccountNumber.text.toString())
        editor?.apply()
    }

    private fun validateData(): Boolean {
        var areAllDataValid = true
        binding.EditTextUserName.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
        }
        binding.EditTextUserLastname.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
        }
        binding.EditTextUserFatherName.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
        }
        binding.EditTextUserPhoneNumber.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
            if (it.text.toString().length != 11) {
                areAllDataValid = false
                it.error = "شماره تلفن نامعتبر است!"
            }
        }
        binding.EditTextUserZipCode.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
            if (it.text.toString().length != 10) {
                areAllDataValid = false
                it.error = "کدپستی نامعتبر است!"
            }
        }
        binding.EditTextUserAccountNumber.let {
            if (it.text.isNullOrBlank()) {
                areAllDataValid = false
                it.error = "تکمیل فیلد اجباری است!"
            }
            if (it.text.toString() == "0") {
                areAllDataValid = false
                it.error = "تعداد حساب ها را بطور صحیح وارد کنید!"
            }
        }

        return areAllDataValid
    }

    private fun putDataInEditTexts() {
        binding.EditTextUserName.setText(profileSharePref.getString(userName,""))
        binding.EditTextUserLastname.setText(profileSharePref.getString(lastName,""))
        binding.EditTextUserFatherName.setText(profileSharePref.getString(father,""))
        binding.EditTextUserZipCode.setText(profileSharePref.getString(zipCode,""))
        binding.EditTextUserPhoneNumber.setText(profileSharePref.getString(phoneNumber,""))
        binding.EditTextUserAccountNumber.setText(profileSharePref.getString(accountNumber,""))
    }
}
