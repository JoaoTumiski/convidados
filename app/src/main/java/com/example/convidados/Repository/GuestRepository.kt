package com.example.convidados.Repository

class GuestRepository private  constructor(){

    //Singleton
    companion object{
        private lateinit var repository: GuestRepository

        fun getInstance(): GuestRepository {
            if(!Companion::repository.isInitialized){
                repository = GuestRepository()
            }

            return repository
        }
    }
}