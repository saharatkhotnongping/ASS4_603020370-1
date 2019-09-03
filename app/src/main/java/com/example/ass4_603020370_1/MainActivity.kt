package com.example.ass4_603020370_1

import android.app.Activity;
import android.app.DatePickerDialog
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*




public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btn_pickDate.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    text_date.setText("" + mDay + "/" + mMonth + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
        }
    }

    fun radio_button_click(view: View) {
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(group.checkedRadioButtonId)
        Toast.makeText(applicationContext, "On click : ${radio.text}", Toast.LENGTH_SHORT)
            .show()
    }

    fun showDetail(view: View) {
        val radio: RadioButton = findViewById(group.checkedRadioButtonId)
        text_show.text =
            "Username: ${edit_name.text}\nPassword: ${edit_pass.text}\nGender: ${radio.text}\nEmail: ${edit_email.text} \nTime: ${text_date.text}"
    }

    fun reset(v: View) {
        edit_name.text.clear()
        edit_pass.text.clear()
        group.clearCheck()
        edit_email.text.clear()
        text_date.text = "dd / mm / yyyy"
        text_show.text = "Show detail"
    }
}