package com.zarisa.bankaccountmanagement

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.zarisa.bankaccountmanagement.databinding.FragmentViewProfileBinding


class ViewProfileFragment : Fragment() {

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
        initViews()
    }

    private fun initViews() {
        putData()
        binding.editButton.setOnClickListener {
            editTime=true
            findNavController().navigate(R.id.action_viewProfileFragment_to_profileFragment)
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