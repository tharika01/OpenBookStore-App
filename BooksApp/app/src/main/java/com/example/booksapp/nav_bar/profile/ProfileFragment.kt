package com.example.booksapp.nav_bar.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.booksapp.databinding.FragmentProfileBinding
import androidx.lifecycle.ViewModelProvider
import com.example.booksapp.BooksDatabase
import com.example.booksapp.MainActivity
import com.example.booksapp.databinding.ActivityReceiverBinding

class ProfileFragment : Fragment()  {

    private var _binding: FragmentProfileBinding? = null
    private lateinit var binding2 : ActivityReceiverBinding
    private lateinit var appDb : BooksDatabase //Reference variable for our database
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        /*lateinit var receiver: List<Receiver>
        receiver = appDb.ReceiverDao().getAll()
        binding.editTextFName.text = receiver.get(0).toString()
        binding.editTextLName.text= receiver.get(1).toString()
        binding.phoneNumber.text = receiver.get(2).toString()
        binding.Address.text = receiver.get(3).toString()*/


        //Logout of app
        binding.logout.setOnClickListener{
            var intent = Intent(this.requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    /*private suspend fun displayData(receiver: List<Receiver>) {
        withContext(Dispatchers.Main){
            binding.editTextFName.text = receiver.get(0).toString()
            binding.editTextLName.text= receiver.get(1).toString()
            binding.phoneNumber.text = receiver.get(2).toString()
            binding.Address.text = receiver.get(3).toString()
        }
    }*/


    override fun onDestroyView() {
        super.onDestroyView()
            _binding = null
        }

    }
