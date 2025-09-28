package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
// Tambahkan import ini
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.myshop.databinding.FragmentAddressBinding

class AddressFragment : Fragment() {
    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // Perbaiki baris ini
            val provinces = resources.getStringArray(R.array.provinces)

            // Perbaiki baris ini
            val adapterProvinces = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item, // Gunakan layout bawaan Android
                provinces
            )

            adapterProvinces.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
            spinnerProvinces.adapter = adapterProvinces

            btnDone.setOnClickListener {
                findNavController().apply {
                    previousBackStackEntry
                        ?.savedStateHandle?.set("address",
                            spinnerProvinces.selectedItem.toString())
                }.navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}