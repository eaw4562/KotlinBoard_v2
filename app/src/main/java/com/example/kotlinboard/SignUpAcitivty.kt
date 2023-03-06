package com.example.kotlinboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlinboard.databinding.ActivitySignUpAcitivtyBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpAcitivty : AppCompatActivity() {

    lateinit var binding : ActivitySignUpAcitivtyBinding

    lateinit var fAuth : FirebaseAuth

    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpAcitivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //인증 초기화
        fAuth = Firebase.auth

        mDbRef = Firebase.database.reference

        binding.btnSignup.setOnClickListener{
            val name = binding.editName.text.toString().trim()
            val id = binding.editId.text.toString().trim()
            val password = binding.editPass.text.toString().trim()

            signUp(name,id,password)
        }
    }

    //회원가입
    private fun signUp(name: String, id: String, password: String) {

        fAuth.createUserWithEmailAndPassword(id,password)
            .addOnCompleteListener(this){ task ->
                if(task.isSuccessful){
                    //회원가입 성공
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    addUserToDatabase(name,id,password, fAuth.currentUser?.uid!!)
                }else{
                    //회원가입 실패
                    Toast.makeText(this,"회원가입 실패",Toast.LENGTH_SHORT).show()
                    Log.d("SignUp","Error: ${task.exception}")
                }
            }
    }

    private fun addUserToDatabase(name: String, id: String,password: String,uId: String) {
        mDbRef.child("user").child(uId).setValue(User(name,id,password,uId))
    }
}