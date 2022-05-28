package lotto.application

import lotto.domain.Lotteries
import lotto.domain.Lotto
import lotto.domain.Price

object WinningAnnouncer {

    fun announce(winner: Lotto, lotteries: Lotteries): Lotteries {
        return lotteries.map { lotto ->
            checkLotteryResult(
                lotto,
                winner.correctNumberCounts(lotto)
            )
        }
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
