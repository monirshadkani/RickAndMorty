package fr.epsi.shadkani.rickandmorty

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil3.load


class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_character_details)



        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_layout_details)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        findViewById<ImageButton>(R.id.back_button_details).setOnClickListener { onBackPressed() }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val charInfo = intent.getSerializableExtra("charInfo") as? CharModel

        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title_character_details)
        toolbarTitle.text = charInfo?.getCharName()

       // val getNameTV = findViewById<TextView>(R.id.nameTVdetails)
        val getStatusTV = findViewById<TextView>(R.id.statusTVdetails)
        val getOriginTV = findViewById<TextView>(R.id.originTVdetails)
        val getSpeciesTV = findViewById<TextView>(R.id.speciesTVdetails)
        val getImageTV = findViewById<ImageView>(R.id.imageTVdetails)

        var statusEmoji = " 🟢"
        if (charInfo?.getCharStatus() == "Dead") statusEmoji = " ☠️"

        //getNameTV.text = charInfo?.getCharName() + " |"
        getStatusTV.text = " " + charInfo?.getCharStatus() + " " + statusEmoji
        getOriginTV.text = charInfo?.getCharOrigin()
        getSpeciesTV .text = charInfo?.getCharSpecies()
        getImageTV.load(charInfo?.getCharImage())

    }
}