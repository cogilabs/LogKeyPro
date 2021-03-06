package fr.logkey.logkeypro.ui.login

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import fr.logkey.logkeypro.Accueil.AccueilActivity
import fr.logkey.logkeypro.R

class EmailPasswordActivity : AppCompatActivity() {

    private val TAG = "EmailPasswordActivity"

    //Les variables globales
    private var email: String? = null
    private var password: String? = null

    //Les composants de l'interface

    private var username: EditText? = null
    private var userPassword: EditText? = null
    private var btnLogin: Button? = null
    private var progressBar: ProgressDialog? = null

    //Ref Firebase
    private lateinit var auth: FirebaseAuth



    private fun initialisation() {

        username = findViewById<View>(R.id.username) as EditText
        userPassword = findViewById<View>(R.id.password) as EditText
        btnLogin = findViewById<View>(R.id.login) as Button
        progressBar = ProgressDialog(this)

        auth = FirebaseAuth.getInstance()

        btnLogin!!.setOnClickListener { connexion() }
    }



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_password)
        initialisation()


    }



    private fun connexion() {
        email = username?.text.toString()
        password = userPassword?.text.toString()
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            progressBar!!.setMessage("Vérification de l'utilisateur...")
            progressBar!!.show()
            Log.d(TAG, "connexion de l'utilisateur.")
            auth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    progressBar!!.hide()
                    if (task.isSuccessful) {
                        // Si l'authentification a réussi, on met à jour les informations de l'utilisateur
                        Log.d(TAG, "Connexion de l'utilisateur avec son email : Succès")
                        majInfoUser()
                    } else {
                        // Si l'authentification a échouée, on affiche un message à l'utilisateur
                        Log.e(TAG, "Connexion de l'utilisateur avec son email : Echec", task.exception)
                        Toast.makeText(this@EmailPasswordActivity, "Echec de l'authentication.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Entrer les détails", Toast.LENGTH_SHORT).show()
        }
    }
    private fun majInfoUser() {
        val intent = Intent(this@EmailPasswordActivity, AccueilActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}