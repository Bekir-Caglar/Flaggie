package com.bekircaglar.flaggie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bekircaglar.flaggie.R
import com.bekircaglar.flaggie.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var username : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        binding.startbutton.setOnClickListener {
            username = binding.enternametext.text.toString()
            if (username.isEmpty()){
                Toast.makeText(requireContext(),"Enter Username",Toast.LENGTH_SHORT).show()
            }
            else{
                val act1 = MainFragmentDirections.actionMainFragmentToFeedFragment(username)
                Navigation.findNavController(view).navigate(act1)
            }



        }

    }





}