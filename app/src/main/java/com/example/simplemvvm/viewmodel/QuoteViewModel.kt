package com.example.simplemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemvvm.model.QuoteModel
import com.example.simplemvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    // Camp privat i mutable: només el ViewModel pot modificar-lo (seguretat).
    private val _quoteModel = MutableLiveData<QuoteModel>()

    // Camp públic de només lectura: el Fragment el llegeix, però no el pot canviar.
    // Anul·lem el get per retornar el valor de la variable privada _quoteModel.
    val quoteModel: LiveData<QuoteModel>
        get() = _quoteModel

    init {
        // Primera frase en crear el ViewModel. Com que el ViewModel sobreviu als
        // canvis d'estat (p. ex. girar la pantalla), la frase no es perd.
        randomQuote()
    }

    // Funció que crida a la funció del Provider
    // (quan hi hagi BD, aquí es cridarien les funcions que facin les queries).
    fun randomQuote() {
        _quoteModel.value = QuoteProvider.random()
    }
}
