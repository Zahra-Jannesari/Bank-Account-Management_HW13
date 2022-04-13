package com.zarisa.bankaccountmanagement

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zarisa.bankaccountmanagement.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    val profileSharePref by lazy { requireActivity().getSharedPreferences("user Information", Context.MODE_PRIVATE) }
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        putDataInEditTexts()
        initViews()
    }

    private fun initViews() {
        binding.saveChangeButton.setOnClickListener { saveEditTextsData() }
    }

    private fun saveEditTextsData() {
        if(validateData()) {
            TODO("Not yet implemented")
        }
    }

    private fun validateData(): Boolean {
        TODO("Not yet implemented")
    }

    private fun putDataInEditTexts() {
        TODO("Not yet implemented")
    }
}
