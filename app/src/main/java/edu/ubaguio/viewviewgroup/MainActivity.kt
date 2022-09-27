package edu.ubaguio.viewviewgroup

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//    val tag = "View ViewGroup"
    override fun onCreate(savedInstanceState: Bundle?) {
//        Log.d(tag, "Create State Entered.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webBtn:Button = findViewById(R.id.btnWeb)
        val dialerBtn:Button = findViewById(R.id.btnDialer)
        val emailBtn:Button = findViewById(R.id.btnEmail)
        val cameraBtn:Button = findViewById(R.id.btnCamera)
        val nextBtn:Button = findViewById(R.id.btnNext)
        val toastBtn:Button = findViewById(R.id.btnToast)

        //explicit intent -> launch or start an activity
        nextBtn.setOnClickListener {
            val i=Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

        //implicit intent -> open URL
        webBtn.setOnClickListener {
            val strURL = "https://www.ubaguio.edu"
            val iBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(strURL))
            startActivity(iBrowser)
        }
        //open Dialer
        dialerBtn.setOnClickListener {
            val iDialer = Intent(Intent.ACTION_DIAL)
            startActivity(iDialer)
        }
        //send email
        val txtMsg = "Hello there"
        val errMsg = "No message found"
        val iEmail = Intent().apply {
            action=Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, txtMsg)
            type="text/plain"
        }
        emailBtn?.setOnClickListener {
            try{
                startActivity(iEmail)
            }catch (e:ActivityNotFoundException){
                Toast.makeText(this@MainActivity, errMsg, Toast.LENGTH_LONG).show()
            }

        }

        cameraBtn.setOnClickListener {
            val strCamera = ""
            val iCamera = Intent()
            startActivity(iCamera)
        }
        //toast
        toastBtn.setOnClickListener {
                Toast.makeText(this, "Goodbye", Toast.LENGTH_SHORT).show()
            }
    }
    override fun onStart(){
        super.onStart()
//        Log.d(tag, "Start State Entered.")
    }

    override fun onStop(){
        super.onStop()
//        Log.d(tag, "Stop State Entered.")
    }

    override fun onResume(){
        super.onResume()
//        Log.d(tag, "Resume State Entered.")
    }

    override fun onPause(){
        super.onPause()
//        Log.d(tag, "Pause State Entered.")
    }

    override fun onRestart(){
        super.onRestart()
//        Log.d(tag, "Restart State Entered.")
    }

    override fun onDestroy(){
        super.onDestroy()
//        Log.d(tag, "Destroy State Entered.")
    }
}