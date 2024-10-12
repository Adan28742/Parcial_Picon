package dev.luisacu.parcial_picon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class splash_inicio : AppCompatActivity(){
    private lateinit var btnGetStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_inicio)

        btnGetStart = findViewById(R.id.btnStart)

        btnGetStart.setOnClickListener {
            empezarLogin()
        }
    }
    private fun empezarLogin(){
        val intent = Intent(this, login_activity::class.java)
        startActivity(intent)
    }
}