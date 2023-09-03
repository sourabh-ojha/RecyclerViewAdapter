package com.example.recyclerviewadapter

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.recyclerviewadapter.databinding.FirstScreenBinding
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    private var dataList = listOf("1", "2")

    private lateinit var binding: FirstScreenBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FirstScreenBinding.inflate(LayoutInflater.from(this@MainActivity))
        setContentView(binding.root)

//        val card1 = findViewById<CardView>(R.id.firstCard)
//        val card2 = findViewById<CardView>(R.id.secondCard)
//        val text1 = findViewById<TextView>(R.id.firstText)
//        val text2 = findViewById<TextView>(R.id.secondText)

        binding.firstCard.setOnClickListener { showCustomDialogBox(0) }
        binding.secondCard.setOnClickListener { showCustomDialogBox(1) }


    }


    private fun showCustomDialogBox(position: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_box)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val dismissDialog: ImageView = dialog.findViewById(R.id.alertCross)
        val crd1Text: MaterialTextView = dialog.findViewById(R.id.text)
        val arrowLeft: ImageView = dialog.findViewById(R.id.arrowLeft)
        val arrorRight: ImageView = dialog.findViewById(R.id.arrowRight)
        crd1Text.text = dataList[position]

//        val crd2Image : ImageView = dialog.findViewById(R.id.secondImage)

        val colorGray = Color.parseColor("#808080")
        val colorBlue = Color.parseColor("#2079be")

        var pos = position


        if (pos == 0) {
            arrowLeft.background.mutate().setTint(colorGray)
            arrorRight.background.mutate().setTint(colorBlue)
        } else {
            arrowLeft.background.mutate().setTint(colorBlue)
            arrorRight.background.mutate().setTint(colorGray)
        }


        arrorRight.setOnClickListener {
            if (pos < dataList.size - 1) {
                pos++

                crd1Text.text = dataList[pos]


            }

            if (pos == 0) {
                arrowLeft.background.mutate().setTint(colorGray)
                arrorRight.background.mutate().setTint(colorBlue)
            } else {
                arrowLeft.background.mutate().setTint(colorBlue)
                arrorRight.background.mutate().setTint(colorGray)
            }
        }
        arrowLeft.setOnClickListener {
            if (pos != 0) {
                pos--

                crd1Text.text = dataList[pos]


            }
            if (pos == 0) {
                arrowLeft.background.mutate().setTint(colorGray)
                arrorRight.background.mutate().setTint(colorBlue)
            } else {
                arrowLeft.background.mutate().setTint(colorBlue)
                arrorRight.background.mutate().setTint(colorGray)
            }
        }


        dismissDialog.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }
}