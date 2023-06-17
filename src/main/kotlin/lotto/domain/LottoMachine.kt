package lotto.domain

object LottoMachine {

    const val MINIMIUM_LOTTO_NUMBER = 1
    const val MAXIMIUM_LOTTO_NUMBER = 45

    private lateinit var mOwnedLotto: OwnedLotto
    private lateinit var mWinLotto: Lotto
    private lateinit var ranking: Ranking
    private lateinit var mBonusNumber: BonusBall
    private var buyAmount: Int = 0

    var rateOfReturn = 0.0
        private set
        get() = ranking.totalWinAmount.toDouble() / buyAmount.toDouble()

    fun buyLotto(amount: Int): OwnedLotto {
        buyAmount = amount
        mOwnedLotto = LottoBuyHelper.buyLotto(buyAmount)
        return mOwnedLotto
    }

    fun generateRanking(): Ranking {
        ranking = Ranking(mOwnedLotto, mWinLotto, mBonusNumber)
        return ranking
    }

    fun setWinLotto(winLotto: Lotto, bonusBall: BonusBall) {
        val isDuplicated = winLotto.lotto.any {
            it.number == bonusBall.bonusNumber.number
        }
        if (isDuplicated) throw IllegalArgumentException("보너스볼은 중복된 숫자가 오면 안됨")
        mWinLotto = winLotto
        mBonusNumber = bonusBall
    }
}
