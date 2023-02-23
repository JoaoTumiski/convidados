package com.example.convidados.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.Constants.DataBaseConstants
import com.example.convidados.Model.GuestModel
import com.example.convidados.R
import com.example.convidados.ViewModel.GuestFormViewModel
import com.example.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel
    private var guestid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]

        binding.ButtonSave.setOnClickListener(this)
        binding.radioPresent.isChecked = true

        observe()

        loadData()

    }

    private fun observe() {
        viewModel.guests.observe(this) {
            binding.editName.setText(it.name)
            if (it.presence) {
                binding.radioPresent.isChecked = true
            } else {
                binding.radioAbsent.isChecked = true
            }
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.Button_save) {
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked

            val model = GuestModel(guestid, name, presence)

            viewModel.save(model)
            //temporario
            finish()
        }
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            val guestid = bundle.getInt(DataBaseConstants.GUEST.id)
            viewModel.get(guestid)
        }
    }
}