package com.example.convidados.View.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.Model.GuestModel
import com.example.convidados.databinding.RowGuestsBinding

class GuestViewHolder(private val bind: RowGuestsBinding) : RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }

}