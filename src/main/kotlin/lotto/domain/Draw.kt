package lotto.domain

import lotto.entity.Lottery
import lotto.entity.WinLotteryResult

class Draw {
    private val lotteryPrice = 1000
    fun calculateBuyNum(amount: Int): Int {
        return amount / lotteryPrice
    }

    fun drawLotteries(num: Int): List<Lottery> {
        return (1..num).map {
            Lottery(makeShuffleNumbers())
        }
    }

    fun calculateWin(winNumbers: List<Int>, lotteries: List<Lottery>): WinLotteryResult {
        val winLotteryResult = WinLotteryResult()
        winLotteryResult.apply {
            lotteries.forEach { checkWin(it.values.intersect(winNumbers.toSet()).size, this) }
        }
        return winLotteryResult
    }

    private fun checkWin(num: Int, winLotteryResult: WinLotteryResult) {
        when (num) {
            3 -> winLotteryResult.matchThree.matchNum += 1
            4 -> winLotteryResult.matchFour.matchNum += 1
            5 -> winLotteryResult.matchFive.matchNum += 1
            6 -> winLotteryResult.matchSix.matchNum += 1
        }
    }

    private fun makeShuffleNumbers(): List<Int> {
        return (1..45).shuffled().subList(0, 6).sorted()
    }
}
