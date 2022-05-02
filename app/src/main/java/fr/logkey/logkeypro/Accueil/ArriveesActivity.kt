package fr.logkey.logkeypro.Accueil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import fr.logkey.logkeypro.R

class ArriveesActivity : AppCompatActivity() {
    lateinit var clickDepartsDuJour : TextView
    lateinit var clickChambres : TextView
    lateinit var clickCommandes : TextView
    lateinit var clickRechercheClient : TextView
    lateinit var clickAccueil : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrivees)

        clickDepartsDuJour = findViewById(R.id.textDeparts)
        val departsIntent = Intent(this, DepartsActivity::class.java)
        clickDepartsDuJour.setOnClickListener {
            startActivity(departsIntent)
        }

        clickChambres = findViewById(R.id.textChambres)
        val chambresIntent = Intent(this, ChambresActivity::class.java)
        clickChambres.setOnClickListener {
            startActivity(chambresIntent)
        }

        clickCommandes = findViewById(R.id.textCommandes)
        val commandesIntent = Intent(this, CommandesActivity::class.java)
        clickCommandes.setOnClickListener {
            startActivity(commandesIntent)
        }

        clickRechercheClient = findViewById(R.id.textRechercheClient)
        val rechercheIntent = Intent(this,RechercheClientActivity::class.java)
        clickRechercheClient.setOnClickListener {
            startActivity(rechercheIntent)
        }

        clickAccueil = findViewById(R.id.imageLogo)
        val accueilIntent = Intent(this,AccueilActivity::class.java)
       clickAccueil.setOnClickListener {
            startActivity(accueilIntent)
        }


    }
}