package fr.epsi.shadkani.rickandmorty

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersListActivity : AppCompatActivity() {
    public var charList: ArrayList<CharModel>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_characters_list)

        //  toolbar

        val toolbar: Toolbar = layoutInflater.inflate(R.layout.toolbar_layout, null) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val title: TextView = toolbar.findViewById(R.id.toolbar_title)
        title.text = getString(R.string.app_name)

        val mainLayout: ConstraintLayout = findViewById(R.id.main)
        mainLayout.addView(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val charRV = findViewById<RecyclerView>(R.id.charRV)
        this.charList = DataHelper.listCharModel(this)
        val charAdapter = CharAdapter(this, charList!!)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        charRV.layoutManager = linearLayoutManager
        charRV.adapter = charAdapter
    }

    fun positionAction(view: View) {
        val position = view.tag as Int
        val intent = Intent(this, CharacterDetailsActivity::class.java)
        intent.putExtra("charInfo", this.charList?.get(position))
        this.startActivity(intent)
    }
}
