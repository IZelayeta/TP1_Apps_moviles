package com.example.tp1_appsmoviles

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editext_name = findViewById<EditText>(R.id.editext_name)
        val editext_mail = findViewById<EditText>(R.id.editext_email)
        val editext_password = findViewById<EditText>(R.id.editext_password)
        val editext_rpassword = findViewById<EditText>(R.id.editext_repeat_password)
        val register_button = findViewById<Button>(R.id.button_register)
        val login_button = findViewById<Button>(R.id.button_login)

        register_button.setOnClickListener {
            val name = editext_name.text.toString()
            val email = editext_mail.text.toString()
            val password = editext_password.text.toString()
            val repeat_password = editext_rpassword.text.toString()

            when {
                name.isEmpty() || email.isEmpty() -> {
                    Toast.makeText(this, "El nombre y el email no pueden estar vacios", Toast.LENGTH_SHORT).show()
                }
                password.length < 6 -> {
                    Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                }
                password != repeat_password -> {
                    Toast.makeText(this, "Las contraseñas no coincide", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Registro con exito", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
        login_button.setOnClickListener{
            finish()
        }
    }
}