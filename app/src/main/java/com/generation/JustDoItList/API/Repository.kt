package com.generation.JustDoItList.API

import com.generation.JustDoItList.model.Categoria
import com.generation.JustDoItList.model.Tarefa
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa> {
        return RetrofitInstance.api.addTarefa(tarefa)
    }

    suspend fun listTarefa(): Response<List<Tarefa>> {
        return RetrofitInstance.api.listTarefa()

    }

    suspend fun updateTarefa(tarefa: Tarefa): Response<Tarefa> {
        return RetrofitInstance.api.updateTarefa(tarefa)

    }

    suspend fun deleteTarefa(id: Long): Response<Tarefa> {
        return RetrofitInstance.api.deleteTarefa(id)
    }

}