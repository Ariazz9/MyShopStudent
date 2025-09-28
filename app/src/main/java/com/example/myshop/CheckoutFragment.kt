package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myshop.databinding.FragmentCheckoutBinding


/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutFragment.newInstance] factory method to
 * create an instance of this fragment.

class CheckoutFragment : Fragment() {


    private var _binding: FragmentCheckoutBinding?=null
    private val binding get()= _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            val args: CheckoutFragmentArgs by navArgs()
            txtProductName.setText(args.productName)

            edtAddress.setOnClickListener {
                val action =
                    CheckoutFragmentDirections.actionCheckoutFragmentToAddressFragment()
                findNavController().navigate(action)
            }

            findNavController().currentBackStackEntry
                ?.savedStateHandle?.let { handle ->
                    handle.getLiveData<String>("address")
                        .observe(viewLifecycleOwner) { res ->
                            edtAddress.setText(res)
                        }
                }

            btnDone.setOnClickListener {
                findNavController().navigateUp()
            }
        }


    }
} */