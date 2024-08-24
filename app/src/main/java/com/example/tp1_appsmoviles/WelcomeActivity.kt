package com.example.tp1_appsmoviles

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radio_group = findViewById<RadioGroup>(R.id.platform_radio_group)
        val image_platform = findViewById<ImageView>(R.id.platform_image)
        val checkbox_other = findViewById<CheckBox>(R.id.checkbox_other)
        val editext_other = findViewById<EditText>(R.id.editext_other)
        val textview_welcome = findViewById<TextView>(R.id.text_welcome)
        val comback_button = findViewById<Button>(R.id.comeback_login)

        val username = intent.getStringExtra("username")
        textview_welcome.text = "Bienvenido a la aplicación $username"

        radio_group.setOnCheckedChangeListener { _ , checkedId ->
            when (checkedId){
                R.id.android_radio_button -> image_platform.setImageResource(R.drawable.android_logo)
                R.id.ios_radio_button -> image_platform.setImageResource(R.drawable.ios_logo)
            }
        }

        checkbox_other.setOnCheckedChangeListener { _ , isChecked ->
            editext_other.visibility =  if (isChecked) View.VISIBLE else View.GONE
        }

        comback_button.setOnClickListener{
            finish()
        }
    }
}