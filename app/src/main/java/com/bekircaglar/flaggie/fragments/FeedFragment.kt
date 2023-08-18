package com.bekircaglar.flaggie.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bekircaglar.flaggie.Flagmap
import com.bekircaglar.flaggie.R
import com.bekircaglar.flaggie.databinding.FragmentFeedBinding
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextInt


class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    var trueans = 0
    var falseans = 0
    val flagmaps = Flagmap()
    val countryNames = flagmaps.flagmap.keys.toList()
    private lateinit var correctCountry :String
    private var handler = Handler(Looper.getMainLooper())
    val bundle:FeedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeedBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        load(view)
        answer(view)



    }

    fun answer(view: View){
        val gameCount = trueans+falseans

        val delayms:Long = 1000

        binding.textView.setOnClickListener {
            if (binding.textView.text.equals(correctCountry)){
                binding.textView.setBackgroundResource(R.drawable.shape1)
                binding.textView.setTextColor(Color.WHITE)
                trueans++

                disablebuttons()
                handler.postDelayed({
                                    load(view)
                }, delayms)


            }
            else{
                binding.textView.setBackgroundResource(R.drawable.shape2)
                binding.textView.setTextColor(Color.WHITE)
                disablebuttons()
                falseans++
             //   binding.textView6.text = "$gameCount  / 10"

                handler.postDelayed({
                    load(view)
                }, delayms)
            }
        }
        binding.textView3.setOnClickListener {
            if (binding.textView3.text.equals(correctCountry)){
                binding.textView3.setBackgroundResource(R.drawable.shape1)
                binding.textView3.setTextColor(Color.WHITE)
                trueans++
                //     binding.textView6.text = "$gameCount  / 10"

                disablebuttons()

                handler.postDelayed({
                    load(view)
                }, delayms)
            }
            else{
                binding.textView3.setBackgroundResource(R.drawable.shape2)
                binding.textView3.setTextColor(Color.WHITE)
                disablebuttons()
                falseans++
                //     binding.textView6.text = "$gameCount  / 10"

                handler.postDelayed({
                    load(view)
                }, delayms)
            }
        }
        binding.textView4.setOnClickListener {
            if (binding.textView4.text.equals(correctCountry)){
                binding.textView4.setBackgroundResource(R.drawable.shape1)
                binding.textView4.setTextColor(Color.WHITE)
                trueans++
                disablebuttons()
                //   binding.textView6.text = "$gameCount  / 10"

                handler.postDelayed({
                    load(view)
                }, delayms)
            }
            else{
                binding.textView4.setBackgroundResource(R.drawable.shape2)
                binding.textView4.setTextColor(Color.WHITE)
                disablebuttons()
                falseans++
                //   binding.textView6.text ="$gameCount  / 10"

                handler.postDelayed({
                    load(view)
                }, delayms)
            }
        }
        binding.textView5.setOnClickListener {
            if (binding.textView5.text.equals(correctCountry)){
                binding.textView5.setBackgroundResource(R.drawable.shape1)
                binding.textView5.setTextColor(Color.WHITE)
                trueans++
                disablebuttons()
                //     binding.textView6.text = "$gameCount  / 10"


                handler.postDelayed({
                    load(view)
                }, delayms)

            }
            else{
                binding.textView5.setBackgroundResource(R.drawable.shape2)
                binding.textView5.setTextColor(Color.WHITE)

                disablebuttons()
                falseans++
                //     binding.textView6.text = "$gameCount  / 10"

                handler.postDelayed({
                    load(view)
                }, delayms)
            }
        }




    }



    fun load(view: View):String{
        val username = bundle.username
        val gameCount = trueans+falseans
        println(gameCount)
        enablebuttons()

        if (gameCount.equals(10)){

            val act2 = FeedFragmentDirections.actionFeedFragmentToResultFragment(username,gameCount,trueans,falseans)
            Navigation.findNavController(view).navigate(act2)

        }




        var randomCountryName = countryNames.random()
        val flagResourceId = flagmaps.flagmap[randomCountryName]



        binding.textView.setBackgroundResource(R.drawable.shape0)
        binding.textView.setTextColor(Color.BLACK)
        binding.textView3.setBackgroundResource(R.drawable.shape0)
        binding.textView3.setTextColor(Color.BLACK)
        binding.textView4.setBackgroundResource(R.drawable.shape0)
        binding.textView4.setTextColor(Color.BLACK)
        binding.textView5.setBackgroundResource(R.drawable.shape0)
        binding.textView5.setTextColor(Color.BLACK)




        val randonfalseoption1 = countryNames.random()
        val randonfalseoption2 = countryNames.random()
        val randonfalseoption3 = countryNames.random()

        val listofanswers = listOf(randomCountryName,randonfalseoption1,randonfalseoption2,randonfalseoption3)
        val  shufledlist = listofanswers.shuffled()



        binding.textView6.text = "$gameCount  / 10"
        if (flagResourceId != null) {
            binding.imageView2.setImageResource(flagResourceId)
            binding.textView.text = shufledlist[0]
            binding.textView3.text = shufledlist[1]
            binding.textView4.text = shufledlist[2]
            binding.textView5.text = shufledlist[3]
        }


        correctCountry = randomCountryName







      return randomCountryName

    }
    fun disablebuttons(){
        binding.textView.isEnabled = false
        binding.textView3.isEnabled = false
        binding.textView4.isEnabled = false
        binding.textView5.isEnabled = false

    }
    fun enablebuttons(){
        binding.textView.isEnabled = true
        binding.textView3.isEnabled = true
        binding.textView4.isEnabled = true
        binding.textView5.isEnabled = true
    }

}