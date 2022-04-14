package com.zarisa.bankaccountmanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zarisa.bankaccountmanagement.databinding.FragmentSelectAccountBinding
import com.zarisa.bankaccountmanagement.databinding.FragmentShowAccountsBinding


class SelectAccountFragment : Fragment() {

    lateinit var binding: FragmentSelectAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_account, container, false)
    }


}