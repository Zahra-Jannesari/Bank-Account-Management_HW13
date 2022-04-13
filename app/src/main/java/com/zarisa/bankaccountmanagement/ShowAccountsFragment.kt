package com.zarisa.bankaccountmanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.zarisa.bankaccountmanagement.databinding.FragmentShowAccountsBinding


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
        setObservers()
        onClicks()
    }

    private fun onClicks() {
        binding.buttonNext.setOnClickListener { viewModel.nextAccount() }
        binding.buttonPrev.setOnClickListener { viewModel.prevAccount() }
    }

    private fun setObservers() {
        viewModel.currentAccountCardNumber.observe(viewLifecycleOwner){
            binding.EditTextCardNumber.setText(it.toString())
        }
        viewModel.currentAccountCredit.observe(viewLifecycleOwner){
            binding.EditTextCredit.setText(it.toString())
        }
        viewModel.currentAccountType.observe(viewLifecycleOwner){
            binding.EditTextAccountType.setText(it.toString())
        }
        viewModel.isNextAvailable.observe(viewLifecycleOwner){
            binding.buttonNext.isEnabled=it
        }
        viewModel.isPrevAvailable.observe(viewLifecycleOwner){
            binding.buttonPrev.isEnabled=it
        }
    }

}