package com.generation.todoapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generation.todoapplication.MainViewModel
import com.generation.todoapplication.databinding.CardlayoutBinding
import com.generation.todoapplication.model.Tarefa

class TarefaAdapter (
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel
        ): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>(){

    private var listTarefa = emptyList<Tarefa>()

    class TarefaViewHolder(val binding: CardlayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(CardlayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        )
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
       val tarefa = listTarefa[position]
        
        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textData.text = tarefa.data
        holder.binding.switchAtivo.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.categoria.descricao

        holder.itemView.setOnClickListener {
            taskClickListener.onTaskClickListener(tarefa)

        }

        holder.binding.switchAtivo
            .setOnCheckedChangeListener { compoundButton, ativo ->
                tarefa.status = ativo
                mainViewModel.updateTarefa(tarefa)

            }
        
    }

    override fun getItemCount(): Int {
        return listTarefa.size

    }

    fun setList(list: List<Tarefa>){
        listTarefa = list.sortedByDescending { it.id }
        notifyDataSetChanged()

    }


}