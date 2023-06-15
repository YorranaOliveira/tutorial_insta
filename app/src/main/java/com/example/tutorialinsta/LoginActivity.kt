package com.example.tutorialinsta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

private const val TAG = "loginActivity"
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //var btnlogin = findViewById<Button>(R.id.btnlogin)
        //var etEmail = findViewById<EditText>(R.id.etEmail)
        //var etPassword = findViewById<EditText>(R.id.etPassword)

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        if(email.isBlank() || password.isBlank()) {
            Toast.makeText(this,"Email/password cannot b empty", Toast.LENGTH_SHORT).show()
            //return@setOnClickListener
        }
        //Firebase authentication check
       val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                goPostsActivity()
                } else {
                Log.i(TAG, "signInWithEmail failed", task.exception)
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goPostsActivity() {
        Log.i(TAG, "goPostsActivity")
    }
}
