package com.gabo.tiktak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.gabo.tiktak.adapter.TicTacAdapter
import com.gabo.tiktak.databinding.FragmentFiveToFiveBinding
import com.gabo.tiktak.model.Item

class FiveToFiveFragment : Fragment() {
    private var binding: FragmentFiveToFiveBinding? = null
    private lateinit var adapter: TicTacAdapter
    private var imageResourceCount = 1
    private var winner: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiveToFiveBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dataProvider.list.clear()
        repeat(25) {
            dataProvider.list.add(Item(R.drawable.ic_square, null, true))
        }

        adapter = TicTacAdapter {
            setImageResource(it)
            it.isClickable = false
        }

        binding?.let {
            it.apply {
                rv.adapter = adapter
                rv.layoutManager = GridLayoutManager(requireContext(), 5)
            }
        }

        adapter.submitList(dataProvider.list)

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
            dataProvider.list[0].imgResource != null -> {
                when {
                    dataProvider.list[0].imgResource == dataProvider.list[1].imgResource && dataProvider.list[1].imgResource == dataProvider.list[2].imgResource -> {
                        winner = if (dataProvider.list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                    dataProvider.list[0].imgResource == dataProvider.list[4].imgResource && dataProvider.list[4].imgResource == dataProvider.list[8].imgResource -> {
                        winner = if (dataProvider.list[8].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                    dataProvider.list[0].imgResource == dataProvider.list[3].imgResource && dataProvider.list[3].imgResource == dataProvider.list[6].imgResource -> {
                        winner = if (dataProvider.list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            dataProvider.list[3].imgResource != null -> {
                when {
                    dataProvider.list[3].imgResource == dataProvider.list[4].imgResource && dataProvider.list[4].imgResource == dataProvider.list[5].imgResource -> {
                        winner = if (dataProvider.list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            dataProvider.list[6].imgResource != null -> {
                when {
                    dataProvider.list[6].imgResource == dataProvider.list[4].imgResource && dataProvider.list[4].imgResource == dataProvider.list[2].imgResource -> {
                        winner = if (dataProvider.list[2].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                    dataProvider.list[6].imgResource == dataProvider.list[7].imgResource && dataProvider.list[7].imgResource == dataProvider.list[8].imgResource -> {
                        winner = if (dataProvider.list[8].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            dataProvider.list[1].imgResource != null -> {
                when {
                    dataProvider.list[1].imgResource == dataProvider.list[4].imgResource && dataProvider.list[4].imgResource == dataProvider.list[7].imgResource -> {
                        winner = if (dataProvider.list[7].imgResource == R.drawable.ic_x) {
                            "Winner Is X"
                        } else {
                            "Winner Is O"
                        }
                    }
                }
            }
            dataProvider.list[2].imgResource != null -> {
                when {
                    dataProvider.list[2].imgResource == dataProvider.list[5].imgResource && dataProvider.list[5].imgResource == dataProvider.list[8].imgResource -> {
                        winner = if (dataProvider.list[8].imgResource == R.drawable.ic_x) {
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