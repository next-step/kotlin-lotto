import domain.Lottery
import domain.Prize

object LotteryMachine {

    fun checkLotteriesWin(
        lotteries: List<Lottery>,
        winningNums: Set<Int>,
        bonusBall: Int,
    ): MutableMap<Prize, Int> {
        val prizeCountMap = mutableMapOf<Prize, Int>()

        for (lottery in lotteries) {
            val prize = lottery.getPrizeByLottery(winningNums, bonusBall) ?: continue
            prizeCountMap[prize] = (prizeCountMap[prize] ?: 0) + 1
        }
        return prizeCountMap
    }

    fun purchaseLotteries(money: Int): Pair<Int, List<Lottery>> {
        val purchasableSize = money / 1000
        val lotteries = List(purchasableSize) { Lottery() }
        return Pair(purchasableSize * 1000, lotteries)
    }
}
