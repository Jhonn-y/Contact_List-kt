package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ContactListAdapter: ListAdapter<Contacts,ContactListAdapter.ContactViewHolder>(ContactDiffUtils()) {

    private lateinit var onClickListener : (Contacts) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact,onClickListener)

    }
    fun onClickListener(onClick : (Contacts) -> Unit ){
        onClickListener = onClick
    }

    class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private val name = view.findViewById<TextView>(R.id.tv_name_contact)
        private val number = view.findViewById<TextView>(R.id.tv_number_contact)
        private val avatar = view.findViewById<ImageView>(R.id.img_contact)

        fun bind(contact : Contacts,onClick: (Contacts) -> Unit){
            name.text = contact.name
            number.text = contact.number
            avatar.setImageResource(contact.avatar)

            view.setOnClickListener {
                onClick.invoke(contact)
            }

        }
    }


    class ContactDiffUtils : DiffUtil.ItemCallback<Contacts>(){
        override fun areItemsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contacts, newItem: Contacts): Boolean {
            return oldItem.name == newItem.name
        }

    }


}