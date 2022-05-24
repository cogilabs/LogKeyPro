package fr.logkey.logkeypro.Accueil

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import fr.logkey.logkeypro.*
import fr.logkey.logkeypro.Chambre.AllerVersChambreActivity
import fr.logkey.logkeypro.Chambre.ChambresDisponiblesActivity
import fr.logkey.logkeypro.ui.login.EmailPasswordActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val TOPIC = "/topics/myTopic2"

class ChambresActivity : AppCompatActivity() {

    lateinit var clickArriveesDuJour : TextView
    lateinit var clickDepartsDuJour : TextView
    lateinit var clickCommandes : TextView
    lateinit var clickRechercheClient : TextView
    lateinit var clickAccueil : ImageView
    lateinit var clickAllerVersChambre : Button
    lateinit var clickChambresDispo : TextView
    lateinit var deconnexionButton : TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var etToken: EditText
    private lateinit var etMessage: EditText
    private lateinit var etTitle: EditText
    private lateinit var buttonEnvoieNotif: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chambres)
        auth = Firebase.auth

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

        deconnexionButton = findViewById(R.id.textLogOut)

        deconnexionButton.setOnClickListener {

            auth.signOut()
            val logoutIntent = Intent(this, EmailPasswordActivity::class.java)
            logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(logoutIntent)

        }
        etTitle = findViewById(R.id.etTitle)
        buttonEnvoieNotif = findViewById(R.id.buttonEnvoieNotif)
        etMessage = findViewById(R.id.etMessage)
        etToken = findViewById(R.id.etToken)

        FirebaseService.sharedPref = getSharedPreferences("sharedPref", MODE_PRIVATE)

        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->

                if (!task.isSuccessful) {
                    Log.w("???", "Fetching FCM token failed", task.exception)
                    return@OnCompleteListener
                }
                val token = task.result
                FirebaseService.token = token.toString()
                etToken.setText(token.toString())

                Log.d("???", "token is $token")
            })
        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)

        buttonEnvoieNotif.setOnClickListener {
            val title = etTitle.text.toString()
            val message = etMessage.text.toString()
            val recipientToken = etToken.text.toString()
            if(title.isNotEmpty() && message.isNotEmpty() && recipientToken.isNotEmpty()) {
                PushNotification(
                    NotificationData(title, message),
                    recipientToken
                ).also {
                    sendNotification(it)
                }
            }
        }
    }
    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.api.postNotification(notification)
            if(response.isSuccessful) {
                //Log.d(TAG, "Response: ${Gson().toJson(response)}")
            } else {
                Log.e(TAG, response.errorBody().toString())
            }
        } catch(e: Exception) {
            Log.e(TAG, e.toString())
        }
    }
}