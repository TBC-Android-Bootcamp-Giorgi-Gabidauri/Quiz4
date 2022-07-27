package com.gabo.tiktak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gabo.tiktak.adapter.TicTacAdapter
import com.gabo.tiktak.dataProvider.list
import com.gabo.tiktak.databinding.FragmentThreeToThreeBinding
import com.gabo.tiktak.model.Item

class ThreeToThreeFragment : Fragment() {
    private var binding: FragmentThreeToThreeBinding? = null
    private lateinit var adapter: TicTacAdapter
    private var winner: String? = null
    private var imageResourceCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeToThreeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.clear()
        repeat(9) {
            list.add(Item(R.drawable.ic_square, null, true))
        }

        adapter = TicTacAdapter {
            setImageResource(it)
            checkWinner()
            it.isClickable = false
        }
        binding?.let {
            it.apply {
                btnStartAgain.setOnClickListener {
                    adapter.submitList(list)
                    tvWinner.text = null
                }
                rv.adapter = adapter
                rv.layoutManager = GridLayoutManager(requireContext(), 3)
            }
        }
        adapter.submitList(list)
    }

    private fun setImageResource(item: Item) {
        if (imageResourceCount % 2 == 0) {
            item.imgResource = R.drawable.ic_x
            imageResourceCount++
        } else {
            item.imgResource = R.drawable.ic_o
            imageResourceCount++
        }
    }

    private fun checkWinner() {
        when {
            list[0].imgResource != null -> {
                when {
                    list[0].imgResource == list[1].imgResource && list[1].imgResource == list[2].imgResource -> {
                        winner = if (list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                    list[0].imgResource == list[4].imgResource && list[4].imgResource == list[8].imgResource -> {
                        winner = if (list[8].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                    list[0].imgResource == list[3].imgResource && list[3].imgResource == list[6].imgResource -> {
                        winner = if (list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            list[3].imgResource != null -> {
                when {
                    list[3].imgResource == list[4].imgResource && list[4].imgResource == list[5].imgResource -> {
                        winner = if (list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            list[6].imgResource != null -> {
                when {
                    list[6].imgResource == list[4].imgResource && list[4].imgResource == list[2].imgResource -> {
                        winner = if (list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                    list[6].imgResource == list[7].imgResource && list[7].imgResource == list[8].imgResource -> {
                        winner = if (list[8].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            list[1].imgResource != null -> {
                when {
                    list[1].imgResource == list[4].imgResource && list[4].imgResource == list[7].imgResource -> {
                        winner = if (list[7].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            list[2].imgResource != null -> {
                when {
                    list[2].imgResource == list[5].imgResource && list[5].imgResource == list[8].imgResource -> {
                        winner = if (list[8].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
        }
        binding?.tvWinner?.text = winner
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}