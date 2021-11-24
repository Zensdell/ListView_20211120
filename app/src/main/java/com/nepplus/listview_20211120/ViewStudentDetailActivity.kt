package com.nepplus.listview_20211120

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_student_detail.*

class ViewStudentDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student_detail)

        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0)
        val address = intent.getStringExtra("address")

        txtRealName.text = name
        txtRealAge.text = "${age}세"
        txtRealAddress.text = address

    }
}