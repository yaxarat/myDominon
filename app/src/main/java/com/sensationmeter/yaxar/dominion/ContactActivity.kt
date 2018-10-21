package com.sensationmeter.yaxar.dominion

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contact.*


class ContactActivity : Activity() {
    val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        photoIv.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (cameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
            }
        }

        sendBtn.setOnClickListener {
            Toast.makeText(this, "Report has been submitted. Thank you.", Toast.LENGTH_LONG).show()
            Thread.sleep(1000)
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
        }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    photoIv.setImageBitmap(data.extras.get("data") as Bitmap)
                }
            }
        }
    }

    private fun setButtonColor() {
        contactBt.setTextColor(0xFF3B74CD.toInt())
    }
}
