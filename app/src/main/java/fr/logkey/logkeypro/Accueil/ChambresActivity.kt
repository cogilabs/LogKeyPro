package fr.logkey.logkeypro.Accueil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import fr.logkey.logkeypro.Chambre.AllerVersChambreActivity
import fr.logkey.logkeypro.Chambre.ChambresDisponiblesActivity
import fr.logkey.logkeypro.R

class ChambresActivity : AppCompatActivity() {

    lateinit var clickArriveesDuJour : TextView
    lateinit var clickDepartsDuJour : TextView
    lateinit var clickCommandes : TextView
    lateinit var clickRechercheClient : TextView
    lateinit var clickAccueil : ImageView
    lateinit var clickAllerVersChambre : Button
    lateinit var clickChambresDispo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chambres)

        clickArriveesDuJour = findViewById(R.id.textArrivees)
        val arriveesIntent = Intent(this, ArriveesActivity::class.java)
        clickArriveesDuJour.setOnClickListener {
            startActivity(arriveesIntent)
        }

        clickDepartsDuJour = findViewById(R.id.textDeparts)
        val departsIntent  = Intent(this, DepartsActivity::class.java)
        clickDepartsDuJour.setOnClickListener {
            startActivity(departsIntent)
        }

        clickCommandes = findViewById(R.id.textCommandes)
        val commandesIntent = Intent(this, CommandesActivity::class.java)
        clickCommandes.setOnClickListener {
            startActivity(commandesIntent)
        }

        clickRechercheClient = findViewById(R.id.textRechercheClient)
        val rechercheIntent = Intent(this, RechercheClientActivity::class.java)
        clickRechercheClient.setOnClickListener {
            startActivity(rechercheIntent)
        }

        clickAccueil = findViewById(R.id.imageLogo)
        val accueilIntent = Intent(this,AccueilActivity::class.java)
        clickAccueil.setOnClickListener {
            startActivity(accueilIntent)
        }

        clickAllerVersChambre = findViewById(R.id.buttonAllerVersChambre)
        val allerVersChambreIntent = Intent(this,AllerVersChambreActivity::class.java)
        clickAllerVersChambre.setOnClickListener {
            startActivity(allerVersChambreIntent)
        }
        clickChambresDispo = findViewById(R.id.textAllerVersChambreDispo)
        val chambresDispoIntent = Intent(this,ChambresDisponiblesActivity::class.java)
        clickChambresDispo.setOnClickListener {
            startActivity(chambresDispoIntent)
        }


    }
}