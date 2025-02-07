package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_NAME = "ContactDetailActivity.KEY_NAME"
const val KEY_NUMBER = "ContactDetailActivity.KEY_NUMBER"
const val KEY_AVATAR = "ContactDetailActivity.KEY_AVATAR"

class ContactDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<TextView>(R.id.tv_name_contact)
        val tvNumber = findViewById<TextView>(R.id.tv_number_contact)
        val avatar = findViewById<ImageView>(R.id.img_contact)
        val tvShare = findViewById<TextView>(R.id.tv_share_contact)

        tvName.text = intent.getStringExtra(KEY_NAME)
        tvNumber.text = intent.getStringExtra(KEY_NUMBER)
        avatar.setImageResource(intent.getIntExtra(KEY_AVATAR, R.drawable.sample1))

        tvShare.setOnClickListener {
            val send: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${tvName.text} ${tvNumber.text}")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(send, null)
            startActivity(shareIntent)

        }
    }

}
