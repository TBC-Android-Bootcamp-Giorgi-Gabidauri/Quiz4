package com.gabo.tiktak.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gabo.tiktak.databinding.ItemViewBinding
import com.gabo.tiktak.model.Item

class TicTacAdapter(private val Click: (Item) -> Unit) :
    RecyclerView.Adapter<TicTacAdapter.TicTacVH>() {
    private var list: List<Item> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Item>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class TicTacVH(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Item, Click: (Item) -> Unit) {
            model.imgResource?.let {
                binding.itemView.setImageResource(model.imgResource!!)
            }
            binding.itemView.isClickable = model.isClickable
            binding.itemView.setBackgroundResource(model.imgBg)
            itemView.setOnClickListener { Click(model) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicTacVH {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TicTacVH(binding)
    }

    override fun onBindViewHolder(holder: TicTacVH, position: Int) {
        val item = list[position]
        holder.bind(item, Click)
    }

    override fun getItemCount(): Int = list.size
}