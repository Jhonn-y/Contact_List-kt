package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_contacts)
        val adapter = ContactListAdapter()
        val imgList = findViewById<ImageView>(R.id.img_list_ic)
        val imgGrig = findViewById<ImageView>(R.id.img_grid_ic)

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        imgGrig.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)

        }
        imgList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)

        }

        adapter.onClickListener { contact ->
            val intent = Intent(this,ContactDetailActivity :: class.java)
            intent.apply{
                putExtra(KEY_NAME,contact.name)
                putExtra(KEY_NUMBER,contact.number)
                putExtra(KEY_AVATAR,contact.avatar)
            }
            startActivity(intent)

        }

    }
}

private val contacts = listOf<Contacts>(
    Contacts(
        name = "Fernanda",
        number = "17777777777",
        avatar = R.drawable.sample1
    ),
    Contacts(
        name = "pedro",
        number = "17777777777",
        avatar = R.drawable.sample2
    ),
    Contacts(
        name = "Leticia",
        number = "17777777777",
        avatar = R.drawable.sample3
    ),
    Contacts(
        name = "Heloisa",
        number = "17777777777",
        avatar = R.drawable.sample4
    ),
    Contacts(
        name = "Amora",
        number = "17777777777",
        avatar = R.drawable.sample5
    ),
    Contacts(
        name = "Carla",
        number = "17777777777",
        avatar = R.drawable.sample6
    ),
    Contacts(
        name = "Julia",
        number = "17777777777",
        avatar = R.drawable.sample7
    ),
    Contacts(
        name = "Gustavo",
        number = "17777777777",
        avatar = R.drawable.sample8
    ),
    Contacts(
        name = "Alan",
        number = "17777777777",
        avatar = R.drawable.sample9
    ),
    Contacts(
        name = "Henrique",
        number = "17777777777",
        avatar = R.drawable.sample10
    ),
    Contacts(
        name = "Sofia",
        number = "17777777777",
        avatar = R.drawable.sample11
    ),
    Contacts(
        name = "João",
        number = "17777777777",
        avatar = R.drawable.sample12
    ),
    Contacts(
        name = "Rafaela",
        number = "17777777777",
        avatar = R.drawable.sample13
    ),
    Contacts(
        name = "Luciano",
        number = "17777777777",
        avatar = R.drawable.sample14
    ),
    Contacts(
        name = "Paula",
        number = "17777777777",
        avatar = R.drawable.sample15
    ),
    Contacts(
        name = "Carol",
        number = "17777777777",
        avatar = R.drawable.sample16
    ),
)