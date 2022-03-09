package com.roynaldi19.pzna01_01androiddasar

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponent(){
        nameEditText = findViewById(R.id.edt_name)
        sayHelloButton = findViewById(R.id.btn_sayHello)
        sayHelloTextView = findViewById(R.id.tv_sayHello)
    }

    private fun checkFingerPrint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "Fingerprint ON")
        } else{
            Log.i("FEATURE", "Fingerprint OF")
        }
    }

    private fun printHello(name: String){
        Log.i("DEBUG", name)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponent()

        checkFingerPrint()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener{
            val firstName = "Roy"
            printHello(firstName)

            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }

            Log.i("ASSET", json)
            Log.i("RAW", sample)

            Log.d("PZN", "this is debug log")
            Log.i("PZN", "this is info log")
            Log.w("PZN", "this is warn log")
            Log.e("PZN", "this is error log")

            Log.i("ValueResources", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResources", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResources", resources.getIntArray(R.array.names).joinToString(""))
            Log.i("ValueResources", resources.getColor(R.color.background, theme).toString())

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.say_hello_textView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("PZN", it)
            }
        }
    }
}