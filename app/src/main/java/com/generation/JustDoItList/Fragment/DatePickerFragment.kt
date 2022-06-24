package com.generation.JustDoItList.Fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DatePickerFragment (
    val TimerPickerListener: TimerPickerListener
    ) : DialogFragment(), DatePickerDialog.OnDateSetListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val C = Calendar.getInstance()
        val Year = C.get(Calendar.YEAR)
        val Month = C.get(Calendar.MONTH)
        val Day = C.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, Year, Month, Day)

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        TimerPickerListener.onDateSelected(calendar.time.toInstant().atZone(
            ZoneId.systemDefault()).toLocalDate())

    }

}

interface TimerPickerListener{

    fun onDateSelected(date: LocalDate)

}