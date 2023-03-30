package com.example.viewmodelejemplo.model

class QuoteProvider {
    companion object {

        fun random(): QuoteModel {
            val random = (0..6).random()
            return quotes[random]
        }

        private val quotes = listOf<QuoteModel>(
            QuoteModel("The way to get started is to quit talking and begin doing.", "Walt Disney"),
            QuoteModel(
                "The pessimist sees difficulty in every opportunity. The optimist sees opportunity in every difficulty.",
                "Winston Churchill"
            ),
            QuoteModel("Don’t let yesterday take up too much of today.", "Will Rogers"),
            QuoteModel(
                "You learn more from failure than from success. Don’t let it stop you. Failure builds character.",
                "Unknown"
            ),
            QuoteModel(
                "It’s not whether you get knocked down, it’s whether you get up.",
                "Vince Lombardi"
            ),
            QuoteModel(
                "If you are working on something that you really care about, you don’t have to be pushed. The vision pulls you.",
                "Steve Jobs"
            ),
            QuoteModel(
                "People who are crazy enough to think they can change the world, are the ones who do.",
                "Rob Siltanen"
            ),

            )
    }
}