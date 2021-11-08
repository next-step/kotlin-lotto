package lotto.domain

class LotteryPaper(budget: LottoBudget) {
    private val lottoGames = mutableListOf<LottoGame>()

    init {
        val numberOfGames = budget.getNumberOfGames()
        repeat(numberOfGames) { lottoGames.add(LottoGame.createWithAutoSelect()) }
    }

    fun getLottoGames() = lottoGames.toList()

    fun getNumberOfGames() = lottoGames.size
}
