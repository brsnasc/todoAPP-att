package com.generation.JustDoItList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*

        Informações presentes na opção "Logcat" do Android Studio ao buildar o aplicativo.

        Error "E" - Logs referente a erros que podem quebrar (crash) o aplicativo,
        Warn "W" - Logs referente a possíveis erros que podem gerar uma quebra (crash) no aplicativo,
        Info "I" - Logs referente a informações dentro do aplicativo,
        Debug "D" - Logs que verificaremos em tempo de produção,
        Verbose - Mostrar todas as informações de log dentro do aplicativo.

        */

    }
}