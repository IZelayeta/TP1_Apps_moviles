package com.example.tp1_appsmoviles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username_editext = findViewById<EditText>(R.id.editext_user)
        val password_editext = findViewById<EditText>(R.id.editext_password)
        val login_button = findViewById<Button>(R.id.button_login)
        val register_button = findViewById<Button>(R.id.button_register)

        login_button.setOnClickListener{
            val username = username_editext.text.toString()
            val password = password_editext.text.toString()

            if (username == "Juan Torres" && password == "1234utn"){
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Datos erroneos", Toast.LENGTH_SHORT).show()
            }
        }

        register_button.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}