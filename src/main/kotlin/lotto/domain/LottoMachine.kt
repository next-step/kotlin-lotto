package lotto.domain

object LottoMachine {

    const val MINIMIUM_LOTTO_NUMBER = 1
    const val MAXIMIUM_LOTTO_NUMBER = 45

    private lateinit var buyedLottoes: LottoNumbers
    private lateinit var mWinNumber: LottoNumber
    private lateinit var ranking: Ranking
    private lateinit var mBonusNumber: BonusNumber
    private var buyAmount: Int = 0

    var rateOfReturn = 0.0
        private set
        get() = ranking.totalWinAmount.toDouble() / buyAmount.toDouble()

    fun buyLottoes(amuont: Int): LottoNumbers {
        buyAmount = amuont
        buyedLottoes = LottoBuyHelper.buyLotto(buyAmount)
        return buyedLottoes
    }

    fun getRanking(): Ranking {
        ranking = Ranking(buyedLottoes, mWinNumber)
        return ranking
    }

    fun setWinNumbers(winNumber: LottoNumber, bonusNumber: BonusNumber) {
        mWinNumber = winNumber
        mBonusNumber = bonusNumber
    }
}
