package lotto.domain

object LottoGame {

    const val LOTTO_PRICE = 1000

    fun start(lottoFactory: LottoFactory): Lotto = lottoFactory.create()

    fun getResultOfGame(lotto: Lotto, winnerLotto: Lotto): LottoGameResult {
        val matches = numberOfMatches(lotto, winnerLotto)
        return LottoGameResult.getResultOfWinning(matches)
    }

    private fun numberOfMatches(lotto: Lotto, winnerLotto: Lotto) =
        lotto.numbers.filter { winnerLotto.numbers.contains(it) }.size
}
