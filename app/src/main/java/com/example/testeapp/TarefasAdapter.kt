// O Adapter

package com.example.testeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.item_tarefas.view.*
import androidx.recyclerview.widget.RecyclerView

class TarefasAdapter (var tarefas: List<Tarefas>): RecyclerView.Adapter<TarefasAdapter.TarefasViewHolder>(){ //Essa class tem como objetivo

    inner class TarefasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefas,parent, false)
        return TarefasViewHolder(view)
    }

    override fun getItemCount(): Int {
       return tarefas.size
    }

    override fun onBindViewHolder(holder: TarefasViewHolder, position: Int) {
        holder.itemView.apply {
            tituloiId.text = tarefas[position].titulo
            checkBoxId.isChecked = tarefas[position].checked
        }
    }


}