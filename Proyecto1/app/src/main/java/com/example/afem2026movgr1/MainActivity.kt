package com.example.afem2026movgr1

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.ImageDecoder
import android.graphics.drawable.AnimatedImageDrawable
import android.os.Build

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop


class MainActivity : AppCompatActivity() {
    @SuppressLint("ThreadConstraint")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val contenedor = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(Color.parseColor("#ffffff"))
        }
        val imagen = ImageView(this).apply {
            setImageResource(R.drawable.harry_p)
            layoutParams = LinearLayout.LayoutParams(700,400).apply {
                gravity = Gravity.CENTER
                bottomMargin = 0


            }

            scaleType = ImageView.ScaleType.CENTER_CROP

        }
        val imagenGif = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(700, 400).apply {
                gravity = Gravity.CENTER
                bottomMargin = 0
                topMargin = 100
                bottomMargin= 100
            }
            scaleType = ImageView.ScaleType.CENTER_CROP

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val source = ImageDecoder.createSource(resources, R.drawable.lrdlm)
                val drawable = ImageDecoder.decodeDrawable(source)
                setImageDrawable(drawable)

                if (drawable is AnimatedImageDrawable) {
                    drawable.start()
                }
            } else {
                setImageResource(R.drawable.lrdlm)
            }
        }

        val textoHola = TextView(this).apply {
            text = "Hola Mundo soy Emily"
            textSize = 28f
            text
            setTextColor(Color.parseColor("#000000"))
            gravity = Gravity.CENTER
            typeface = android.graphics.Typeface.DEFAULT_BOLD

        }
        contenedor.addView(imagen)
        contenedor.addView(imagenGif)
        contenedor.addView(textoHola)
        setContentView(contenedor)
    }


}