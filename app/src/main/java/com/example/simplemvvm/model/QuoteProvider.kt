package com.example.simplemvvm.model

object QuoteProvider {

    private val quotes = listOf(
        QuoteModel("Talk is cheap. Show me the code.", "Linus Torvalds"),
        QuoteModel("Simplicity is prerequisite for reliability.", "Edsger W. Dijkstra"),
        QuoteModel("Premature optimization is the root of all evil.", "Donald Knuth"),
        QuoteModel("The best way to predict the future is to invent it.", "Alan Kay"),
        QuoteModel(
            "Any fool can write code that a computer can understand. " +
                "Good programmers write code that humans can understand.",
            "Martin Fowler"
        ),
        QuoteModel("Make it work, make it right, make it fast.", "Kent Beck")
    )

    // Retorna una frase aleatòria
    fun random(): QuoteModel = quotes.random()

    // Retorna totes les frases
    fun all(): List<QuoteModel> = quotes
}
