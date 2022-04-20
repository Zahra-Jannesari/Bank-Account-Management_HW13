package com.zarisa.bankaccountmanagement.account.manage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zarisa.bankaccountmanagement.R
import com.zarisa.bankaccountmanagement.model.SharedViewModel

class DeleteAllAccountsFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_all_accounts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDialog()
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setMessage("Are you sure you want to delet All of your registered accounts?")
            setTitle("warning!")
            setPositiveButton("yes!") { dialog, which ->
                viewModel.deleteAllAccounts()
                Toast.makeText(requireContext(),"All accounts deleted!",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_deleteAllAccountsFragment_to_profileFragment)
            }
            setNegativeButton("never mind:)"){dialog, which ->
                Toast.makeText(requireContext(),"You can delete accounts whenever you want.",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_deleteAllAccountsFragment_to_profileFragment)
            }
        }
        builder.create().show()
    }
}