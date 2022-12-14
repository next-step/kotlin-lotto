package lotto.domain

class LotteryMachine {

    fun buyLotteries(payAmount: Int): Lotteries {
        val howMany = (payAmount / PRICE)
        val lotteryList = List(howMany) { Lottery(LottoNumber.allNumbers().shuffled().subList(0, 6)) }
        return Lotteries(lotteryList)
    }

    fun getResult(lotteries: Lotteries, lastWinningLottery: Lottery): LotteryResult {
        return LotteryResult(
            lotteries.lotteries.map { it.countSameLottoNumbers(lastWinningLottery) }.toList()
        )
    }

    fun calculateReturnRate(payAmount: Int, lotteryResult: LotteryResult): Double {
        return 0.1
    }

    companion object {
        const val PRICE = 1_000
    }
}
