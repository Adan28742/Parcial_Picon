package dev.luisacu.parcial_picon

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class login_activity : AppCompatActivity() {

    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var btnLogin: Button

    // Credenciales válidas
    private val validEmail = "admin@travelapp.com"
    private val validPassword = "admin123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        inputEmail = findViewById(R.id.inputEmail)
        inputPassword = findViewById(R.id.inputPassd)
        btnLogin = findViewById(R.id.btnlogin)

        btnLogin.setOnClickListener {
            validateCredentials()
        }
    }

    private fun validateCredentials() {
        val email = inputEmail.editText?.text.toString()
        val password = inputPassword.editText?.text.toString()

        if (email == validEmail && password == validPassword) {
            // Guardar en SharedPreferences
            val sharedPreferences: SharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()

            // Mostrar un mensaje de éxito
            Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            // Mostrar un mensaje de error
            Toast.makeText(this, "Credenciales invalidas", Toast.LENGTH_SHORT).show()
        }
    }
}