package com.example.selfproject4_4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.selfproject4_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.SwAgree.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                binding.Text2.visibility = android.view.View.VISIBLE
                binding.Rgroup1.visibility = android.view.View.VISIBLE
            } else {
                binding.SwAgree.isChecked = false

                binding.Rgroup1.clearCheck()

                binding.imageView.setImageDrawable(null)

                binding.Text2.visibility = android.view.View.INVISIBLE
                binding.Rgroup1.visibility = android.view.View.INVISIBLE

                binding.imageView.visibility = android.view.View.INVISIBLE

                binding.BtnFinish.visibility = android.view.View.INVISIBLE
                binding.BtnClear.visibility = android.view.View.INVISIBLE
            }
        }
        binding.Rgroup1.setOnCheckedChangeListener{group,checkedId ->
            when(checkedId){
                R.id.RdoOreo -> binding.imageView.setImageResource(R.drawable.oreo)
                R.id.RdoPie -> binding.imageView.setImageResource(R.drawable.pie)
                R.id.RdoQ -> binding.imageView.setImageResource(R.drawable.q10)
                else -> binding.imageView.setImageDrawable(null)
            }
            if (checkedId != -1) {
                binding.imageView.visibility = android.view.View.VISIBLE
                binding.BtnFinish.visibility = android.view.View.VISIBLE
                binding.BtnClear.visibility = android.view.View.VISIBLE
            }
        }
        binding.BtnFinish.setOnClickListener {
            finish()
        }
        binding.BtnClear.setOnClickListener {
            binding.SwAgree.isChecked = false

            binding.Rgroup1.clearCheck()

            binding.imageView.setImageDrawable(null)

            binding.Text2.visibility = android.view.View.INVISIBLE
            binding.Rgroup1.visibility = android.view.View.INVISIBLE

            binding.imageView.visibility = android.view.View.INVISIBLE

            binding.BtnFinish.visibility = android.view.View.INVISIBLE
            binding.BtnClear.visibility = android.view.View.INVISIBLE
        }
    }
}