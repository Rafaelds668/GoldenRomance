package com.example.goldenromance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mForgotPasswordButton: Button
    private lateinit var mEmail: EditText
    private var flag = 0
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private var email = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        mAuth = FirebaseAuth.getInstance()
        flag = 0
        mForgotPasswordButton = findViewById(R.id.resetPasswordButton)
        mEmail = findViewById(R.id.resetPasswordEmail)

        mForgotPasswordButton.setOnClickListener {
            email = mEmail.text.toString()
            if (email == "") {
                Toast.makeText(this@ForgetPasswordActivity, "El email está vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!email.matches(emailPattern.toRegex())) {
                Toast.makeText(this@ForgetPasswordActivity, "Dirección de correo incorrecta", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            mAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(object : OnCompleteListener<Void> {
                override fun onComplete(task: Task<Void>) {
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this@ForgetPasswordActivity,
                            "Las instrucciones para cambiar la contraseña fueron enviadas al correo",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(this@ForgetPasswordActivity, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })
            if (flag == 0)
                Toast.makeText(this@ForgetPasswordActivity, "La dirección de correo no fue encontrada", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        val btnClick = Intent(this@ForgetPasswordActivity, LoginActivity::class.java)
        startActivity(btnClick)
        super.onBackPressed()
        finish()
        return
    }
}
