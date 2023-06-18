package lotto.domain

object LottoMachine {

    const val MINIMIUM_LOTTO_NUMBER = 1
    const val MAXIMIUM_LOTTO_NUMBER = 45
    const val LOTTERY_PRICE = 1000

    private lateinit var mLotteriesByMachine: LotteryGroup
    private lateinit var mLotteriesByHand: LotteryGroup
    private lateinit var mWinLotto: Lottery
    private lateinit var mRanking: Ranking
    private lateinit var mBonusNumber: LottoNumber
    private var buyAmount: Int = 0

    var rateOfReturn = 0.0
        private set
        get() = mRanking.totalWinAmount.toDouble() / buyAmount.toDouble()

    fun buyLottery(amount: Int, lotteriesByHand: LotteryGroup): LotteryGroup? {

        runCatching {
            buyAmount = amount
            mLotteriesByHand = lotteriesByHand
            val handCount = lotteriesByHand.lotteries.size
            val buyCount = amount / LOTTERY_PRICE
            check(buyCount >= handCount) {
                "로또를 살 수 있는 금액보다 수동으로 많은 수를 구매할 수 없습니다. 게임을 다시 실행하세요."
            }
            mLotteriesByMachine = LottoBuyHelper.buyLotto(buyAmount - handCount * LOTTERY_PRICE)
            return mLotteriesByMachine
        }.getOrElse {
            println(it.message)
            return null
        }
    }

    fun generateRanking(): Ranking {
        mRanking = Ranking(mLotteriesByHand, mLotteriesByMachine, mWinLotto, mBonusNumber)
        return mRanking
    }

    fun setWinLotto(winLotto: Lottery, bonusBall: LottoNumber) {
        val isDuplicated = winLotto.lottery.any {
            it.number == bonusBall.number
        }
        if (isDuplicated) throw IllegalArgumentException("보너스볼은 중복된 숫자가 오면 안되므로 게임을 종료함")
        mWinLotto = winLotto
        mBonusNumber = bonusBall
    }
}
