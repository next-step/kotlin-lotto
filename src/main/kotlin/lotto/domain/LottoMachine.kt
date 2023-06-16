package lotto.domain

object LottoMachine {

    const val MINIMIUM_LOTTO_NUMBER = 1
    const val MAXIMIUM_LOTTO_NUMBER = 45

    private lateinit var buyedLottoes: LottoNumbers
    private lateinit var winNumber: LottoWinNumber
    private lateinit var ranking: Ranking
    private var buyAmount: Int = 0

    var rateOfReturn = 0.0
        private set
        get() = ranking.totalWinAmount.toDouble() / buyAmount.toDouble()

    fun buyLottoes(amuont: Int): LottoNumbers {
        buyAmount = amuont
        buyedLottoes = LottoBuyHelper.buyLotto(buyAmount)
        return buyedLottoes
    }

    fun setRanking(winNumbers: List<Int>): Ranking {
        winNumber = LottoWinNumber(winNumbers)
        ranking = Ranking(buyedLottoes, winNumber)
        return ranking
    }
}
