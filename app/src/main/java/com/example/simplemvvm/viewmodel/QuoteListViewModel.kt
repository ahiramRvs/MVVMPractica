package com.example.simplemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemvvm.model.QuoteModel
import com.example.simplemvvm.model.QuoteProvider

class QuoteListViewModel : ViewModel() {

    private val _quotes = MutableLiveData<List<QuoteModel>>()

    val quotes: LiveData<List<QuoteModel>>
        get() = _quotes

    // Funció que crida al Provider per obtenir totes les frases
    fun loadQuotes() {
        _quotes.value = QuoteProvider.all()
    }
}
