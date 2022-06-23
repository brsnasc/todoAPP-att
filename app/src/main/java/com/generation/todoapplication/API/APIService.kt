package com.generation.todoapplication.API

import com.generation.todoapplication.model.Categoria
import com.generation.todoapplication.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface APIService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("tarefa")
    suspend fun addTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

    @GET("tarefa")
    suspend fun listTarefa(): Response<List<Tarefa>>

    @PUT("tarefa")
    suspend fun updateTarefa(
        @Body tarefa: Tarefa
    ): Response<Tarefa>

}