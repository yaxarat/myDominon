package com.sensationmeter.yaxar.dominion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    private val password: String = "password"
    private val username: String = "Yashar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // On enter button press
        loginBtn.setOnClickListener {
            credentialCheck()
        }
    }

    // Checks password.
    private fun credentialCheck() {
        // THIS IS NOT A SAFE WAY TO STORE/CHECK PASSWORD. HOWEVER, FOR THE MOMENT, THIS WILL BE USED UNTIL ACTUAL SETTINGS PAGE IS CREATED.
        if(passwordEt.text.toString() == password && usernameEt.text.toString() == username) {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Username or password is incorrect.", Toast.LENGTH_LONG).show()
        }
    }
}
