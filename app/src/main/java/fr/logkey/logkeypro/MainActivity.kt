package fr.logkey.logkeypro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.logkey.logkeypro.Accueil.AccueilActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToAccueil("")
    }
    private  fun goToAccueil(Accueil: String){
        val intent = Intent(this, AccueilActivity::class.java)
        intent.putExtra("Acceuil", Accueil)
        startActivity(intent)
    }
}