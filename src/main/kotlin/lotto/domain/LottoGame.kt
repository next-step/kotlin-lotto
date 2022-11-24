package lotto.domain

object LottoGame {

    const val LOTTO_PRICE = 1000

    fun start(lottoFactory: LottoFactory): Lotto = lottoFactory.create()

    fun getResultOfGames(gameBoard: ArrayList<Lotto>, winnerLotto: Lotto): List<LottoGameResult> {
        return gameBoard.map { numberOfMatches(it, winnerLotto) }
            .map { LottoGameResult.getResultOfWinning(it) }
    }

    private fun numberOfMatches(lotto: Lotto, winnerLotto: Lotto) =
        lotto.numbers.filter { winnerLotto.numbers.contains(it) }.size
}
