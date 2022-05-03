package fr.logkey.logkeypro.Commandes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import fr.logkey.logkeypro.Accueil.*
import fr.logkey.logkeypro.R
import fr.logkey.logkeypro.Accueil.RechercheClientActivity

class PriseEnChargeCommandeActivity : AppCompatActivity() {

    lateinit var clickArriveesDuJour : TextView
    lateinit var clickDepartsDuJour : TextView
    lateinit var clickChambres : TextView
    lateinit var clickRechercheClient : TextView
    lateinit var clickAccueil : ImageView
    lateinit var clickDetail : TextView
    lateinit var clickCommandes : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prise_en_charge_commande)

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
        val chambresIntent  = Intent(this, ChambresActivity::class.java)
        clickChambres.setOnClickListener {
            startActivity(chambresIntent)
        }

        clickRechercheClient = findViewById(R.id.textRechercheClient)
        val rechercheIntent = Intent(this, RechercheClientActivity::class.java)
        clickRechercheClient.setOnClickListener {
            startActivity(rechercheIntent)
        }

        clickAccueil = findViewById(R.id.imageLogo)
        val accueilIntent = Intent(this, AccueilActivity::class.java)
        clickAccueil.setOnClickListener {
            startActivity(accueilIntent)
        }


        clickCommandes = findViewById(R.id.textCommandes)
        val commandesIntent = Intent(this, CommandesActivity::class.java)
        clickCommandes.setOnClickListener {
            startActivity(commandesIntent)
        }
    }
}