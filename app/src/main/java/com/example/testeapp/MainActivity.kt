package com.example.testeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.adicionar
import kotlinx.android.synthetic.main.activity_main.editText
import kotlinx.android.synthetic.main.activity_main.recycleV

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var tarefasList = mutableListOf(
            Tarefas("testando aqui", false),
            Tarefas("123 aqui", true),
            Tarefas("Matemática aqui", false),
            Tarefas("Física aqui", true),
            Tarefas("testando aqui", false),
            Tarefas("testando aqui", true)

        )
        val adapter = TarefasAdapter(tarefasList)
        recycleV.adapter = adapter
        recycleV.layoutManager = LinearLayoutManager(this)

        adicionar.setOnClickListener{
            val titulo = editText.text.toString()
            val tarefa = Tarefas(titulo, false)

            tarefasList.add(tarefa)
            adapter.notifyDataSetChanged()
            adapter.notifyItemInserted(tarefasList.size -1)
        }
    }
}