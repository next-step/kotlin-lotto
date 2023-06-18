package lotto.domain

object LottoMachine {

    const val MINIMIUM_LOTTO_NUMBER = 1
    const val MAXIMIUM_LOTTO_NUMBER = 45
    const val LOTTERY_PRICE = 1000

    private lateinit var mMyLotteryGroup: MyLotteryGroup
    private lateinit var mWinLotto: Lottery
    private lateinit var mRanking: Ranking
    private lateinit var mBonusNumber: LottoNumber
    lateinit var rateOfReturn: RateOfReturn
        private set

    fun buyLottery(amount: Int, lotteriesByHand: LotteryGroup): MyLotteryGroup? {

        runCatching {
            val lotteryGroupByMachine = LottoBuyHelper.buyLottoByMachine(amount, lotteriesByHand)
            mMyLotteryGroup = MyLotteryGroup(
                lotteriesByHand.lotteries + lotteryGroupByMachine.lotteries,
                lotteriesByHand.lotteries.size,
                lotteryGroupByMachine.lotteries.size
            )
            return mMyLotteryGroup
        }.getOrElse {
            println(it.message)
            return null
        }
    }

    fun generateRanking(): Ranking {
        mRanking = Ranking(mMyLotteryGroup, mWinLotto, mBonusNumber)
        rateOfReturn = RateOfReturn(mRanking, mMyLotteryGroup.lotteries.size * LOTTERY_PRICE)
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
