package com.generation.JustDoItList.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.generation.JustDoItList.MainViewModel
import com.generation.JustDoItList.databinding.CardlayoutBinding
import com.generation.JustDoItList.model.Tarefa

class TarefaAdapter (
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,
    val context: Context
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

        holder.binding.buttonDeletar.setOnClickListener {
            showAlertDialog(tarefa.id)

        }
        
    }

    override fun getItemCount(): Int {
        return listTarefa.size

    }

    fun setList(list: List<Tarefa>){
        listTarefa = list.sortedByDescending { it.id }
        notifyDataSetChanged()

    }

    private fun showAlertDialog(id: Long) {
        AlertDialog.Builder(context)
            .setTitle("Deletar Tarefa.")
            .setMessage("Essa alteração é irreversível. Deletar mesmo assim?")
            .setPositiveButton("SIM") {
                _,_ -> mainViewModel.deleteTarefa(id)

            }

            .setNegativeButton("NÃO") {
                _,_ ->

            } .show()
    }


}