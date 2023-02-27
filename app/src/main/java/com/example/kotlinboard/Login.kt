package com.example.kotlinboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlinboard.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

   lateinit var binding: ActivityLoginBinding
   lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fAuth = Firebase.auth

        binding.btnLogin.setOnClickListener{

            val id = binding.editId.text.toString()
            val password = binding.editPass.text.toString()

            login(id,password)
        }

        binding.btnJoin.setOnClickListener {
            val intent = Intent(this, SignUpAcitivty::class.java)
            startActivity(intent)
        }
    }

    private fun login(id: String, password: String) {

        fAuth.signInWithEmailAndPassword(id,password)
            .addOnCompleteListener(this){ task->
                if(task.isSuccessful){
                    //로그인 성공
                    val intent = Intent(this@Login, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    //로그인 실패
                    Toast.makeText(this,"로그인 실패",Toast.LENGTH_SHORT).show()
                    Log.d("Login","Error : ${task.exception}")
                }
            }
    }
}
