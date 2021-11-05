package lotto.domain

import lotto.domain.ExceptionType.BUDGET_UNSIGNED_INT

class LotteryPaper(budget: Int) {
    private val lottoGames = mutableListOf<LottoGame>()

    init {
        require(budget >= 0) { BUDGET_UNSIGNED_INT }
        val numberOfGames = budget / PRICE_OF_GAME
        repeat(numberOfGames) { lottoGames.add(LottoGame(makeRandomNumbers())) }
    }

    fun getLottoGames() = lottoGames.toList()

    fun getNumberOfGames() = lottoGames.size

    private fun makeRandomNumbers() =
        numberPool
            .shuffled()
            .slice(0..5)
            .sorted()

    companion object {
        const val PRICE_OF_GAME = 1000
        val numberPool = List(45) { v -> v + 1 }
    }
}
