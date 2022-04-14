package com.zarisa.bankaccountmanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.zarisa.bankaccountmanagement.databinding.FragmentSelectAccountBinding
import com.zarisa.bankaccountmanagement.databinding.FragmentShowAccountsBinding


class SelectAccountFragment : Fragment() {

    lateinit var binding: FragmentSelectAccountBinding
    private val viewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSelectAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.chosenAccountType.observe(viewLifecycleOwner) {
            binding.EditTextAccountType.setText(it)
        }
        viewModel.chosenAccountCredit.observe(viewLifecycleOwner) {
            binding.EditTextCredit.setText(it)
        }
        binding.buttonShowAccountInfo.setOnClickListener {
            binding.EditTextCardNumber.text.let {
                if (it.isNullOrBlank())
                    Toast.makeText(requireContext(),"شماره کارت را وارد کنید.",Toast.LENGTH_SHORT).show()
                else
                    viewModel.getAccountInfo(it.toString().toInt()) }
        }
    }


}