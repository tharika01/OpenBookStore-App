package com.example.booksapp.nav_bar.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.booksapp.databinding.FragmentProfileBinding
import androidx.lifecycle.ViewModelProvider
import com.example.booksapp.BooksDatabase
import com.example.booksapp.LandingActivity
import com.example.booksapp.databinding.ActivityReceiverBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private lateinit var binding2 : ActivityReceiverBinding
    private lateinit var appDb : BooksDatabase //Reference variable for our database
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var em : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val intent = Intent()
        val fname = intent.getStringExtra("email")
        em = binding.editTextEmailAddress
        em.text = fname

        //Logout of app
        binding.logoutBtn.setOnClickListener{
            var intent = Intent(this.requireContext(), LandingActivity::class.java)
            startActivity(intent)
        }

        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}