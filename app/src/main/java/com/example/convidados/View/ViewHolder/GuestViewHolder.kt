package com.example.convidados.View.ViewHolder

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.Model.GuestModel
import com.example.convidados.View.Listner.OnGuestListner
import com.example.convidados.databinding.RowGuestsBinding

class GuestViewHolder(private val bind: RowGuestsBinding, private val listner: OnGuestListner) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name

        bind.textName.setOnClickListener {
            listner.onClick(guest.id)
        }

        bind.textName.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton("Sim") { dialog, which ->
                    listner.onDelete(guest.id)}
                .setNegativeButton("não", null)
                .create()
                .show()
            true
        }

    }

}