package com.example.booksapp.nav_bar.home

import android.content.Intent
import android.content.Intent.getIntent
import android.content.Intent.parseIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.booksapp.R
import com.example.booksapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var intent: Intent
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var em : TextView

    private lateinit var b : TextView
    private lateinit var avail : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val intent : Inent
        //val title = parseIntent().getStringExtra("title")

        /*fun Intent.getData(key: String): String {
            return extras?.getString(key) ?: "intent is null"
        }
        val title = intent.getData("title")

        b = binding.bookName
        b.text = title*/

       /* avail = binding.availability
        avail.setOnClickListener {
            AlertDialog.Builder(activity)
                .setMessage("$title is in stock")
                .setPositiveButton("OK") { dialog, which ->

                }
                .create()
                .show()
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}