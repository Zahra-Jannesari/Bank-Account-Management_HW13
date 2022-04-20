package com.zarisa.bankaccountmanagement.account.manage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.zarisa.bankaccountmanagement.databinding.FragmentShowAccountsBinding
import com.zarisa.bankaccountmanagement.model.SharedViewModel


class ShowAccountsFragment : Fragment() {
    lateinit var binding: FragmentShowAccountsBinding
    private val viewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding= FragmentShowAccountsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updateList()
        setObservers()
        onClicks()
    }

    private fun onClicks() {
        binding.buttonNext.setOnClickListener { viewModel.nextAccount() }
        binding.buttonPrev.setOnClickListener { viewModel.prevAccount() }
    }

    private fun setObservers() {
        viewModel.currentAccountCardNumber.observe(viewLifecycleOwner){
            if(it!=null)
            binding.EditTextCardNumber.setText(it.toString())
        }
        viewModel.currentAccountCredit.observe(viewLifecycleOwner){
            if(it!=null)
            binding.EditTextCredit.setText(it.toString())
        }
        viewModel.currentAccountType.observe(viewLifecycleOwner){
            if(it!=null)
            binding.EditTextAccountType.setText(it.toString())
        }
        viewModel.isNextAvailable.observe(viewLifecycleOwner){
            if(it!=null)
            binding.buttonNext.isEnabled=it
        }
        viewModel.isPrevAvailable.observe(viewLifecycleOwner){
            if(it!=null)
            binding.buttonPrev.isEnabled=it
        }
    }

}