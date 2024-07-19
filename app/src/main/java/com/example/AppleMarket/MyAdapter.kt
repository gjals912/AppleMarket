package com.example.AppleMarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemBinding

class MyAdapter(
    private val mItems:List<MyItem>,
    private val itemClickListener: (MyItem, Int) -> Unit
    ) : RecyclerView.Adapter<MyAdapter.Holder>() {

    inner class Holder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: MyItem){
            binding.ivProfill.setImageResource(item.ivProfill)
            binding.tvTitle.text = item.tvTitle
            binding.tvSubTitle.text = item.tvSubtitle
            binding.tvUser.text = item.tvUser
            binding.btnUserKeyword.text = item.btnUserKeyword
            binding.btnUserKeyword2.text = item.btnUserKeyword2
            binding.btnUserKeyword3.text = item.btnUserKeyword3
//                itemClickListener(item, this.adapterPosition) // 튜터님 코드랑 비교!!!, ctrl + 스페이스바!!!
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
        holder.bind(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

}
