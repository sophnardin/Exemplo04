package com.example.exemplo04

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class PixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pix)
        setSupportActionBar(findViewById(R.id.tbPix))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnContinuar)
        val edtChave = findViewById<EditText>(R.id.edtChave)
        btConf.setOnClickListener {
            val data = intent
            val valorPix = findViewById<EditText>(R.id.edtvalorPix)
            val nvalor = valorPix.text.toString().toDouble()
            if(nvalor>nsaldo) {
                Toast.makeText(this, "saldo de $nsaldo é insuficiente para o valor de $nvalor", LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "$nsaldo", LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtChave.setText("".toString())
            finish()

        }
    }
    fun pixVoltar (view: View) {
        val editText = findViewById<EditText>(R.id.edtChave)
        val voltar = editText.text.toString()
    }

        }