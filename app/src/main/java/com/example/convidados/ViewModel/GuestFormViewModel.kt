package com.example.convidados.ViewModel

import androidx.lifecycle.ViewModel
import com.example.convidados.Repository.GuestRepository

class GuestFormViewModel : ViewModel() {

    private val repository = GuestRepository.getInstance()



}