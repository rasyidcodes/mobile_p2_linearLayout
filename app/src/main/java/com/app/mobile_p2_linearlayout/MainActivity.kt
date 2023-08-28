package com.app.mobile_p2_linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.mobile_p2_linearlayout.databinding.ActivityMainBinding
import java.text.MessageFormat.format

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        with(binding){

            binding.btHitung.setOnClickListener{
                val  weight = binding.etBeratBadan.text.toString().toFloatOrNull()
                val height = binding.etTinggiBadan.text.toString().toFloatOrNull()

                if (weight != null && height != null && height > 0) {
                    val bmi = weight / (height/100 * height/100)
                    val stringValue = String.format("%.${2}f", bmi)

                    binding.tvResult.text = stringValue
                } else {
                    Toast.makeText(applicationContext,"invalid value", Toast.LENGTH_SHORT).show()
                }

            }

            binding.btToast.setOnClickListener{
                Toast.makeText(applicationContext,"ini toast!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}