package com.example.convidados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.databinding.ActivityGuestFormBinding
import com.example.convidados.ui.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var ViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.ButtonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true
    }

    override fun onClick(v: View) {
        if (v.id == R.id.Button_save){
        }
    }
}