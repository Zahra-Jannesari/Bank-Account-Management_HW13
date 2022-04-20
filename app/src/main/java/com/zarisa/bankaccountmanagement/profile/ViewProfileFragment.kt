package com.zarisa.bankaccountmanagement.profile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zarisa.bankaccountmanagement.R
import com.zarisa.bankaccountmanagement.databinding.FragmentViewProfileBinding


class ProfileFragment : Fragment() {

    lateinit var binding: FragmentViewProfileBinding
    private val profileSharePref: SharedPreferences by lazy {
        requireActivity().getSharedPreferences(
            "user Information",
            Context.MODE_PRIVATE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val actionBar = (requireActivity().actionBar)
//        actionBar?.setDisplayHomeAsUpEnabled(false)
        binding = FragmentViewProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        choseCorrectFragment()
        initViews()
    }
    private fun choseCorrectFragment() {
        if (profileSharePref.getString(userName, "") == "")
            findNavController().navigate(R.id.action_profileFragment_to_changeProfileFragment)
        else return
    }
    private fun initViews() {
        putData()
        binding.editButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_changeProfileFragment)
        }
    }

    private fun putData() {
        binding.EditTextUserName.setText(profileSharePref.getString(userName,""))
        binding.EditTextUserLastname.setText(profileSharePref.getString(lastName,""))
        binding.EditTextUserFatherName.setText(profileSharePref.getString(father,""))
        binding.EditTextUserZipCode.setText(profileSharePref.getString(zipCode,""))
        binding.EditTextUserPhoneNumber.setText(profileSharePref.getString(phoneNumber,""))
        binding.EditTextUserAccountNumber.setText(profileSharePref.getString(accountNumber,""))
    }


}