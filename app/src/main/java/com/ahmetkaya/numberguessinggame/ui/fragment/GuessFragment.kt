package com.ahmetkaya.numberguessinggame.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ahmetkaya.numberguessinggame.R
import com.ahmetkaya.numberguessinggame.databinding.FragmentGuessBinding
import kotlin.random.Random

class GuessFragment : Fragment() {
    private lateinit var binding: FragmentGuessBinding
    private var randomNumber = 0
    private var counter = 5
    private var bundle = Bundle()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGuessBinding.inflate(inflater, container, false)
        val view = binding.root

        generateRandomNumber()
        transition()

        return view
    }

    fun generateRandomNumber(){
        randomNumber = Random.nextInt(101) // 1-100
        Log.e("Random Number",randomNumber.toString())
    }

    fun transition() {
        binding.buttonGuess.setOnClickListener {
            val inputString = binding.editTextEntry.text.toString()

            if (TextUtils.isEmpty(inputString)) {
                Toast.makeText(context, "Please enter a number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val guess = Integer.parseInt(inputString)
            counter -= 1

            if (guess == randomNumber) {
                bundle.putBoolean("result", true)
                Navigation.findNavController(it).navigate(R.id.resultFragmentTransition, bundle)
            } else if (guess > randomNumber) {
                binding.textViewHelp.text = "Reduce the Number!"
                binding.textViewCounter.text = "Remaining Rights $counter"
            } else {
                binding.textViewHelp.text = "Increase the Number!"
                binding.textViewCounter.text = "Remaining Rights $counter"
            }

            if (counter == 0) {
                bundle.putBoolean("result", false)
                Navigation.findNavController(it).navigate(R.id.resultFragmentTransition, bundle)
            }

            binding.editTextEntry.setText("")
        }
    }


}