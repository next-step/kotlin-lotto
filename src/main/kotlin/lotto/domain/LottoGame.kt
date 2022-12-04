package lotto.domain

import lotto.domain.lotto.LottoNumber

object LottoGame {

    const val LOTTO_PRICE = 1000

    fun pick(numberOfGames: Int, lottoFactory: LottoFactory) =
        List(numberOfGames) { lottoFactory.create() }

    fun getResultOfGames(gameBoard: List<Lotto>, winnerLotto: Lotto, bonusNumber: LottoNumber) =
        gameBoard.map {
            LottoGameResult.getResultOfWinning(
                numberOfMatches(it, winnerLotto),
                bonusOfMatches(it, bonusNumber)
            )
        }

    private fun numberOfMatches(lotto: Lotto, winnerLotto: Lotto) =
        lotto.numbers.filter { winnerLotto.numbers.contains(it) }.size

    private fun bonusOfMatches(lotto: Lotto, bonus: LottoNumber) =
        lotto.numbers.filter { bonus == it }.size

    fun calculateNumberOfAutoGames(numberOfTotal: Int, numberOfManual: Int) =
        numberOfTotal - numberOfManual

    fun setGameBoard(manualLotto: List<Lotto>, autoLotto: List<Lotto>): List<Lotto> {
        val gameBoard = mutableListOf<Lotto>()
        gameBoard.addAll(manualLotto)
        gameBoard.addAll(autoLotto)
        return gameBoard
    }
}
