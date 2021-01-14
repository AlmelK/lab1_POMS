package com.example.firstlab

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getSum(view: View){
        val text1 = findViewById<EditText>(R.id.editTextTextPersonName)
        val text2 = findViewById<EditText>(R.id.editTextTextPersonName2)

        val restext = findViewById<TextView>(R.id.textView)
        
        val numt1 = text1.text.toString()
        val numt2 = text2.text.toString()

        if(numt1 == "" || numt2==""){
            restext.text = "please enter number"
        }
        else {
            val x: Double = numt1.toDouble()
            val y: Double = numt2.toDouble()

            restext.text = (x+y).toString()
        }

        text1.setText(null)
        text2.setText(null)
    }

    fun alertName(view: View){
        val text1 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val text2 = findViewById<EditText>(R.id.editTextTextPersonName4)

        val surname = text1.text.toString()
        val name = text2.text.toString()

        if(surname=="" || name==""){
            val textToast = "Please enter data!"
            val dur = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext,textToast,dur)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
        else{
            val builder = AlertDialog.Builder(this)
            builder.setMessage(surname + " " + name)
            builder.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })
            builder.show()
        }

        text1.setText(null)
        text2.setText(null)
    }

    fun solveEqv(view: View){
        val textA = findViewById<EditText>(R.id.editTextTextPersonName5)
        val textB = findViewById<EditText>(R.id.editTextTextPersonName6)
        val textC = findViewById<EditText>(R.id.editTextTextPersonName7)

        val str1 = textA.text.toString()
        val str2 = textB.text.toString()
        val str3 = textC.text.toString()

        if(str1 == "" || str2 == "" || str3 == "")
        {
            val textToast = "Please enter data!"
            val dur = Toast.LENGTH_SHORT

            val toast = Toast.makeText(applicationContext,textToast,dur)
            toast.setGravity(Gravity.BOTTOM,0,0)
            toast.show()
        }
        else{
            val a: Double= str1.toDouble()
            val b: Double= str2.toDouble()
            val c: Double= str3.toDouble()

            textA.setText(null)
            textB.setText(null)
            textC.setText(null)

            val d: Double= b*b - 4*a*c
            if(d == 0.0){
                val x: Double = (-b)/(2*a)

                val builder = AlertDialog.Builder(this)
                builder.setMessage("x = " +x.toString())
                builder.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
                builder.show()
            }
            else if (d > 0)
            {
                val x1: Double= (-b - sqrt(d))/(2*a)
                val x2: Double= (-b + sqrt(d))/(2*a)

                val builder = AlertDialog.Builder(this)
                builder.setMessage("x1 = " +x1.toString() +", x2 = " + x2.toString())
                builder.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
                builder.show()
            }
            else{
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Error!")
                builder.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
                builder.show()
            }
        }



/*        val builder = AlertDialog.Builder(this)
        builder.setMessage(a.toString() + " " + b.toString() + " " + c.toString())
        builder.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })
        builder.show()*/

    }
}