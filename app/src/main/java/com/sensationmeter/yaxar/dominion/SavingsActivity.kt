package com.sensationmeter.yaxar.dominion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_savings.*

class SavingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings)

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
            val intent = Intent(applicationContext, CameraActivity::class.java)
            startActivity(intent)
        }
        tempCb.setOnClickListener {
            checkSaving()
        }
        waterCb.setOnClickListener {
            checkSaving()
        }
        lightCb.setOnClickListener {
            checkSaving()
        }
    }

    private fun setButtonColor() {
        savingsBt.setTextColor(0xFF3B74CD.toInt())
    }

    private fun checkSaving() {
        when (checkedStat()) {
            0 -> {
                setText("Monthly Saving: \$0.00")
                setImage(0)
            }
            1 -> {
                setText("Monthly Saving: \$20.40")
                setImage(1)
            }
            2 -> {
                setText("Monthly Saving: \$15.30")
                setImage(2)
            }
            3 -> {
                setText("Monthly Saving: \$10.20")
                setImage(3)
            }
            12 -> {
                setText("Monthly Saving: \$35.70")
                setImage(12)
            }
            123 -> {
                setText("Monthly Saving: \$45.90")
                setImage(123)
            }
            13 -> {
                setText("Monthly Saving: \$30.60")
                setImage(13)
            }
            23 -> {
                setText("Monthly Saving: \$25.50")
                setImage(23)
            }
        }
    }

    private fun checkedStat(): Int {
        if (tempCb.isChecked and waterCb.isChecked and lightCb.isChecked) {
            return 123
        }
        if (tempCb.isChecked and waterCb.isChecked and !lightCb.isChecked) {
            return 12
        }
        if (tempCb.isChecked and lightCb.isChecked and !waterCb.isChecked) {
            return 13
        }
        if (waterCb.isChecked and lightCb.isChecked) {
            return 23
        }
        if (tempCb.isChecked) {
            return 1
        }
        if (waterCb.isChecked) {
            return 2
        }
        if (lightCb.isChecked) {
            return 3
        }
        if (!tempCb.isChecked and !waterCb.isChecked and !lightCb.isChecked) {
            return 0
        }
        return 0
    }

    private fun setText(savingText: String) {
        savingTv.text = savingText
    }

    private fun setImage(code: Int) {
        when(code) {
            0 -> graphIv.setImageResource(R.drawable.origin)
            1 -> graphIv.setImageResource(R.drawable.opt1)
            2 -> graphIv.setImageResource(R.drawable.opt2)
            3 -> graphIv.setImageResource(R.drawable.opt3)
            12 -> graphIv.setImageResource(R.drawable.opt12)
            23 -> graphIv.setImageResource(R.drawable.opt23)
            13 -> graphIv.setImageResource(R.drawable.opt13)
            123 -> graphIv.setImageResource(R.drawable.opt123)
        }
    }
}
