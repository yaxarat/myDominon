package com.sensationmeter.yaxar.dominion

import android.annotation.SuppressLint
import android.content.Intent
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rewards.*

class RewardsActivity : Activity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)

        progressBar.setProgress(270, true)

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
        redeemBtn.setOnClickListener {
            Toast.makeText(this, "500 pts required.", Toast.LENGTH_LONG).show()
        }
    }
}
