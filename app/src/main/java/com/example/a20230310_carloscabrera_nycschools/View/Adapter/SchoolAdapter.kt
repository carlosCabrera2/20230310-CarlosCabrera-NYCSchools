package com.example.a20230310_carloscabrera_nycschools.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a20230310_carloscabrera_nycschools.databinding.FragmentSchoolItemViewBinding
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponse
import com.example.a20230310_carloscabrera_nycschools.model.SchoolResponseItem

class SchoolAdapter (
    private val itemSet: MutableList<SchoolResponseItem> = mutableListOf(),
    private val onItemClick: (SchoolResponseItem) -> Unit
        ): RecyclerView.Adapter<SchoolViewHolder>(){

    fun updateItems(newItems: List<SchoolResponseItem>){
        if (itemSet != newItems){
            itemSet.clear()
            itemSet.addAll(newItems)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        return SchoolViewHolder(
            FragmentSchoolItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemSet.size
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {

        holder.bind(itemSet[position], onItemClick)
    }
}

class SchoolViewHolder(
    private val binding: FragmentSchoolItemViewBinding
        ):RecyclerView.ViewHolder(binding.root) {

            fun bind(item: SchoolResponseItem, onItemClick: (SchoolResponseItem) -> Unit){

                binding.tvSchoolName.text = item.schoolName
                binding.tvSchoolLocation.text = item.primaryAddressLine1
                binding.tvSchoolPhoneNumber.text = item.phoneNumber
                binding.tvSchoolEmail.text = item.schoolEmail

                itemView.setOnClickListener {
                    onItemClick(item)
                }

            }
}
