package com.sensationmeter.yaxar.dominion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account.*

class AccountActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        // Initializations
        setButtonColor()

        // Button listeners
        homeBt.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }
        accountBt.setOnClickListener {
            val intent = Intent(applicationContext, AccountActivity::class.java)
            startActivity(intent)
        }
        savingsBt.setOnClickListener {
            val intent = Intent(applicationContext, SavingsActivity::class.java)
            startActivity(intent)
        }
        contactBt.setOnClickListener {
            val intent = Intent(applicationContext, ContactActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setButtonColor() {
        accountBt.setTextColor(0xFF3B74CD.toInt())
    }
}
