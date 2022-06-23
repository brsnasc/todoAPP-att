package com.generation.todoapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todoapplication.API.Repository
import com.generation.todoapplication.model.Categoria
import com.generation.todoapplication.model.Tarefa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(
    private val repository: Repository
        ): ViewModel() {

    var tarefaSelecionada: Tarefa? = null

    private val _myCategoriaResponse = MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> = _myCategoriaResponse

    private val _myTarefaResponse = MutableLiveData<Response<List<Tarefa>>>()

    val myTarefaResponse: LiveData<Response<List<Tarefa>>> = _myTarefaResponse

    val dataSelecionada = MutableLiveData<LocalDate>()

    init {

        listCategoria()
    }


    fun listCategoria(){
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val response = repository.listCategoria()
                _myCategoriaResponse.value = response

            }catch (e: Exception){
                Log.d("Error", e.message.toString())
            }
        }
    }

    fun addTarefa(tarefa: Tarefa){
        viewModelScope.launch {
            try {

                val response = repository.addTarefa(tarefa)
                Log.d("Olá", response.body().toString())
                listTarefa()

            }catch (e: Exception){
                Log.d("Error", e.message.toString())
            }
        }
    }

    fun listTarefa(){
        viewModelScope.launch {
            try {

                val response = repository.listTarefa()
                _myTarefaResponse.value = response

            }catch (e: Exception){
                Log.d("Error", e.message.toString())
            }
        }
    }

    fun updateTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            try {
                repository.updateTarefa(tarefa)
                listTarefa()
            } catch (e: Exception) {
                Log.d("Error", e.message.toString())

            }
        }
    }
}