package com.ahmetkaya.numberguessinggame.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ahmetkaya.numberguessinggame.R
import com.ahmetkaya.numberguessinggame.databinding.FragmentGuessBinding

class GuessFragment : Fragment() {
    private lateinit var binding: FragmentGuessBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGuessBinding.inflate(inflater, container, false)
        val view = binding.root

        transition()

        return view
    }

    fun transition(){
        binding.buttonGuess.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.resultFragmentTransition)
        }
    }

}