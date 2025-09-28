package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myshop.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }

        binding.viewName.text = getString(R.string.nama_label) + " " + getString(R.string.default_value)
        binding.viewNIM.text = getString(R.string.nim_label) + " " + getString(R.string.default_value)
        binding.viewAlamat.text = getString(R.string.alamat_label) + " " + getString(R.string.default_value)

        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Triple<String, String, String>>("homeData")
            ?.observe(viewLifecycleOwner) { (nama, nim, alamat) ->
                binding.viewName.text = getString(R.string.nama_label) + " " + nama
                binding.viewNIM.text = getString(R.string.nim_label) + " " + nim
                binding.viewAlamat.text = getString(R.string.alamat_label) + " " + alamat
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



