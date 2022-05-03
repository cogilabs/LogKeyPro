package fr.logkey.logkeypro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.FirebaseApp
import fr.logkey.logkeypro.Accueil.AccueilActivity
import fr.logkey.logkeypro.ui.login.EmailPasswordActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToAccueil("")
    }
    private  fun goToAccueil(Accueil: String){
        val intent = Intent(this, EmailPasswordActivity::class.java)
        intent.putExtra("Acceuil", Accueil)
        startActivity(intent)
    }
}