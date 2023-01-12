package com.example.booksapp.nav_bar.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.booksapp.Entities.book_category.BioActivity
import com.example.booksapp.Entities.book_category.ChemActivity
import com.example.booksapp.Entities.book_category.MathActivity
import com.example.booksapp.Entities.book_category.PhyActivity
import com.example.booksapp.Entities.login.SignUpActivity
import com.example.booksapp.R
import com.example.booksapp.databinding.FragmentCategoryBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*return inflater.inflate(R.layout.fragment_search, container, false)

        val view: View = inflater!!.inflate(R.layout.fragment_search, container, false)

        binding.imageButtonChem.setOnClickListener { view ->
            ("btnSetup", "Selected")
        }*/

        //On click listener to go to chemistry page
        binding.imageButtonChem.setOnClickListener{
            /*val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)*/
            startActivity(Intent(requireContext(), ChemActivity::class.java))
        }
        binding.imageButtonBio.setOnClickListener{
            /*val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)*/
            startActivity(Intent(requireContext(), BioActivity::class.java))
        }
        binding.imageButtonMath.setOnClickListener{
            /*val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)*/
            startActivity(Intent(requireContext(), MathActivity::class.java))
        }
        binding.imageButtonPhy.setOnClickListener{
            /*val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)*/
            startActivity(Intent(requireContext(), PhyActivity::class.java))
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}