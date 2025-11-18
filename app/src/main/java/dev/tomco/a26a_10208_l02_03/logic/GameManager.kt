package dev.tomco.a26a_10208_l02_03.logic

import dev.tomco.a26a_10208_l02_03.model.Country
import dev.tomco.a26a_10208_l02_03.model.DataManager
import dev.tomco.a26a_10208_l02_03.utilities.Constants

class GameManager(private val lifeCount: Int = 3) {

    var score: Int = 0
        private set

    private val allCountries: List<Country> = DataManager.getAllCountries()

    var currentIndex: Int = 0
        private set

    var wrongAnswers: Int = 0
        private set

    val currentCountry: Country
        get() = allCountries[currentIndex]

    val isGameEnded: Boolean
        get() = currentIndex == allCountries.size

    val isGameOver: Boolean
        get() = wrongAnswers == lifeCount

    fun checkAnswer(expected: Boolean){
        // correct answer and update score
        if (expected == currentCountry.canEnter)
            score += Constants.GameLogic.SCORE_DEFAULT

        // wrong answer update wrongs
        else
            wrongAnswers++

        // Next!
        currentIndex++
    }

}