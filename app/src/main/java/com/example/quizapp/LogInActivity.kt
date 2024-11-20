package com.example.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityLogInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnSignUp.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.email.editText?.text.toString(),
                binding.password.editText?.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created !!!", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "User Not Created !!!", Toast.LENGTH_SHORT).show()
                    }
            }
        }

    }
}