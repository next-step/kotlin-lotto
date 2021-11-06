package lotto.domain

class LotteryPaper(budget: LottoBudget) {
    private val lottoGames = mutableListOf<LottoGame>()

    init {
        val numberOfGames = budget.getNumberOfGames()
        repeat(numberOfGames) { lottoGames.add(LottoGame(makeRandomNumbers())) }
    }

    fun getLottoGames() = lottoGames.toList()

    fun getNumberOfGames() = lottoGames.size

    private fun makeRandomNumbers() =
        numberPool
            .shuffled()
            .slice(0..5)
            .sorted()
            .map { LottoNumber(it) }

    companion object {
        val numberPool = List(45) { v -> v + 1 }
    }
}
