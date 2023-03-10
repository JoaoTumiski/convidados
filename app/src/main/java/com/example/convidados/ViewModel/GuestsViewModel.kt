package com.example.convidados.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.Model.GuestModel
import com.example.convidados.Repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository =  GuestRepository.getInstance(application.applicationContext)

    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuests

    fun getAll(){
        listAllGuests.value =  repository.getAll()
    }

    fun getAbsent(){
        listAllGuests.value =  repository.getAbsent()
    }

    fun getPresent(){
        listAllGuests.value =  repository.getAbsent()
    }

    fun delete(id:Int){
        repository.delete(id)
    }
}