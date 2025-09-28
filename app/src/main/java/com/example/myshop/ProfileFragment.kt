package com.example.myshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myshop.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Klik provinsi → pindah ke AddressFragment
        binding.edtAlamat.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToAddressFragment()
            findNavController().navigate(action)
        }

        // Ambil hasil dari AddressFragment
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<String>("address")
            ?.observe(viewLifecycleOwner) { result ->
                binding.edtAlamat.setText(result)
            }

        // di ProfileFragment
        binding.btnSimpan.setOnClickListener {
            val nama = binding.edtName.text.toString()
            val nim = binding.edtNIM.text.toString()
            val alamat = binding.edtAlamat.text.toString()

            findNavController().getBackStackEntry(R.id.homeFragment)
                .savedStateHandle
                .set("homeData", Triple(nama, nim, alamat))

            // tetap stay di Profile, jangan navigate ke Home
            findNavController().popBackStack()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

