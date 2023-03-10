package com.example.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class AnswerCheckActivity : AppCompatActivity() {
    private lateinit var choice: TextView
    private lateinit var Purple: CheckBox
    private lateinit var Green: CheckBox
    private lateinit var Orange: CheckBox
    private lateinit var Submit: Button
    private  var username:String = ""
    private  var result:String = ""
    private  var colors:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer)

        username = intent.getStringExtra("username").toString()
        println(username)
        colors = intent.getStringExtra("choice").toString()
        println(colors)
        choice = findViewById(R.id.chosen)
        choice.setText("You Chose $colors")
        Purple = findViewById(R.id.blueBox)
        Green = findViewById(R.id.redBox)
        Orange = findViewById(R.id.yellowBox)
        Submit = findViewById(R.id.mix)
        result = intent.getStringExtra("result").toString()
        println(result)

        Submit.setOnClickListener {
            if ( Purple.isChecked || Green.isChecked || Orange.isChecked  ) {
                if(Purple.isChecked && result == "purple" || Green.isChecked && result == "green" || Orange.isChecked && result == "orange" ) {
                    val intent = Intent( this, SuccessActivity::class.java)
                    intent.putExtra("name",username)
                    startActivity(intent)
                }
                else {
                    val intent = Intent( this, WrongActivity::class.java)
                    intent.putExtra("name",username)
                    startActivity(intent)
                }
            }
            else {
                Toast.makeText(this, "Please check a color", Toast.LENGTH_SHORT).show()
            }
        }

    }

}