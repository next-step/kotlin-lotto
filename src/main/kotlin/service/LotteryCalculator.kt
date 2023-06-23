package service

import domain.Lottery
import domain.WinningFinder

object LotteryCalculator {
    fun calculatePrizes(lotteries: List<Lottery>, winningFinder: WinningFinder): Map<Int, Int> {
        return lotteries.map { winningFinder.getPrizeMoneyByMatched(it) }
            .groupingBy { it }
            .eachCount()
    }
}
