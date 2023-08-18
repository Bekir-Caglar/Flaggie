package com.bekircaglar.flaggie.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bekircaglar.flaggie.R
import com.bekircaglar.flaggie.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    val bundle:ResultFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentResultBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = bundle.resultuser
        val corrcetans = bundle.correctans
        val incorrectans = bundle.incorrectans
        val totalcount = bundle.totalQ
        binding.scoreText.text = "Your score is $corrcetans in $totalcount"
        binding.usernametext.text = username
        binding.button.setOnClickListener {

            val act3 = ResultFragmentDirections.actionResultFragmentToMainFragment()
            Navigation.findNavController(view).navigate(act3)


        }


    }

}