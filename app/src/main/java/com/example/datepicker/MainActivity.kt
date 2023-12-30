package com.example.datepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.datepicker.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectBtn.setOnClickListener {

            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                this,
                0,
                DatePickerDialog.OnDateSetListener { _, year, month, day ->
                binding.selectedDateTv.text = "$day/${month+1}/$year"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            calendar.set(Calendar.DAY_OF_MONTH,10)
            datePickerDialog.datePicker.maxDate = calendar.timeInMillis //tanlash uchun\
            calendar.set(Calendar.DAY_OF_MONTH, 4)
            datePickerDialog.datePicker.minDate = calendar.timeInMillis //malum bir kundan malum bir kungacha

            datePickerDialog.show()
        }
    }
}