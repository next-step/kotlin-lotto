package lotto.application

import lotto.domain.Lotto
import lotto.domain.Price

object WinningAnnouncer {

    fun announce(winner: Lotto, lotteries: List<Lotto>): List<Lotto> {
        val targetNumbers = winner.sortedNumbers()
        return lotteries.map { lotto ->
            val sortedNumbers = lotto.sortedNumbers()
            checkLotteryResult(
                lotto,
                countCorrectNumbers(targetNumbers, sortedNumbers)
            )
        }
    }

    private fun countCorrectNumbers(o1: List<Int>, o2: List<Int>): Int {
        return o1.zip(o2)
            .count { it.first == it.second }
    }

    private fun checkLotteryResult(lotto: Lotto, correctedNumberCounts: Int): Lotto {
        return when (correctedNumberCounts) {
            6 -> Lotto(lotto.numbers, Price.FIRST)
            5 -> Lotto(lotto.numbers, Price.SECOND)
            4 -> Lotto(lotto.numbers, Price.THIRD)
            3 -> Lotto(lotto.numbers, Price.FOURTH)
            else -> lotto
        }
    }
}
