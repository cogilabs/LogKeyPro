package fr.logkey.logkeypro.RechercheClient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import fr.logkey.logkeypro.Accueil.*
import fr.logkey.logkeypro.R

class ResultatRechercheClientActivity : AppCompatActivity() {

    lateinit var clickArriveesDuJour : TextView
    lateinit var clickDepartsDuJour : TextView
    lateinit var clickChambres : TextView
    lateinit var clickCommandes : TextView
    lateinit var clickAccueil : ImageView
    lateinit var clickVersFicheClient : TextView
    lateinit var clickRechercheClient : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultat_recherche_client)


        clickArriveesDuJour = findViewById(R.id.textArrivees)
        val arriveesIntent = Intent(this, ArriveesActivity::class.java)
        clickArriveesDuJour.setOnClickListener {
            startActivity(arriveesIntent)
        }

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

        clickAccueil = findViewById(R.id.imageLogo)
        val accueilIntent = Intent(this, AccueilActivity::class.java)
        clickAccueil.setOnClickListener {
            startActivity(accueilIntent)
        }

        clickRechercheClient = findViewById(R.id.textRechercheClient)
        val rechercheIntent = Intent(this, RechercheClientActivity::class.java)
        clickRechercheClient.setOnClickListener {
            startActivity(rechercheIntent)
        }
        clickVersFicheClient = findViewById(R.id.textAccesFicheClient1)
        val ficheIntent = Intent(this, FicheClientActivity::class.java)
        clickVersFicheClient.setOnClickListener {
            startActivity(ficheIntent)
        }
    }
}