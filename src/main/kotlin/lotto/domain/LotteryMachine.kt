package lotto.domain

class LotteryMachine {

    fun buyLotteries(payAmount: Int): Lotteries {
        val howMany = (payAmount / PRICE)
        val lotteryList = List(howMany) { Lottery(LottoNumber.allNumbers().shuffled().subList(0, 6)) }
        return Lotteries(lotteryList)
    }

    fun getResult(lotteries: Lotteries, lastWinningLottery: List<Int>): LotteryResult {

        return LotteryResult()
    }

    companion object {
        const val PRICE = 1_000
    }
}
