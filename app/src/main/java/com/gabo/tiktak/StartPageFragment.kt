package com.gabo.tiktak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gabo.tiktak.databinding.FragmentStartPageBinding

class StartPageFragment : Fragment() {
    private var binding: FragmentStartPageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartPageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {
            it.apply {
                cbThreeToThree.setOnCheckedChangeListener { _, _ ->
                    if (cbThreeToThree.isChecked) {
                        cbFourToFour.isChecked = false
                        cbFiveToFive.isChecked = false
                    }
                }
                cbFourToFour.setOnCheckedChangeListener { _, _ ->
                    if (cbFourToFour.isChecked) {
                        cbThreeToThree.isChecked = false
                        cbFiveToFive.isChecked = false
                    }
                }
                cbFiveToFive.setOnCheckedChangeListener { _, _ ->
                    if (cbFiveToFive.isChecked) {
                        cbThreeToThree.isChecked = false
                        cbFourToFour.isChecked = false
                    }
                }
                btnStartGame.setOnClickListener {
                    when {
                        cbThreeToThree.isChecked -> {
                            findNavController().navigate(R.id.action_startPageFragment_to_threeToThreeFragment)
                        }
                        cbFourToFour.isChecked -> {
                            findNavController().navigate(R.id.action_startPageFragment_to_fourToFourFragment)
                        }
                        cbFiveToFive.isChecked -> {
                            findNavController().navigate(R.id.action_startPageFragment_to_fiveToFiveFragment)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}