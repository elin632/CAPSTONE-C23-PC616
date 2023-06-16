package com.captsone.disastershield.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.captsone.disastershield.databinding.PhoneCardBinding
import com.captsone.disastershield.model.Contact

class PhoneViewAdapter(private val items: List<Contact>,
    val onItemClickListener: (Contact) -> Unit
    ) :
    RecyclerView.Adapter<PhoneViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PhoneCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: PhoneCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Contact) {
            binding.root.setOnClickListener {
                onItemClickListener(item)
            }
            binding.phoneName.text = item.name
            binding.phoneNumber.text = item.phoneNumber
        }
    }
}
