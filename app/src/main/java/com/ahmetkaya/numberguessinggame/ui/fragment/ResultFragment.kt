package com.ahmetkaya.numberguessinggame.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.ahmetkaya.numberguessinggame.R
import com.ahmetkaya.numberguessinggame.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        getResult()
        transition()

        return view
    }

    fun getResult(){
        val result = arguments?.getBoolean("result") ?: false

        if (result){
            binding.imageViewResult.setImageResource(R.drawable.happy_picture)
            binding.textViewResult.text = "YOU WİN!"
        }else{
            binding.imageViewResult.setImageResource(R.drawable.sad_picture)
            binding.textViewResult.text = "YOU LOST!"
        }
    }

    fun transition(){
        binding.buttonResult.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.mainFragmentTransition)
        }
    }

}