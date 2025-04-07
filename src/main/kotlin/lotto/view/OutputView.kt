package lotto.view

import lotto.domain.Lottery
import lotto.domain.Lottos
import lotto.domain.Prize

object OutputView {
    fun printLottos(lottos: Lottos) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.values.forEach {
            println("[${it.rawNumbers.joinToString()}]")
        }
    }

    fun printWinningStatistics(lottery: Lottery) {
        val result =
            buildString {
                append("\nWinning Statistics\n------------------\n")
                appendPrizes(lottery)
                append("Total return rate is %.2f (A rate below 1 means a loss)".format(lottery.returnRate))
            }

        println(result)
    }

    private fun StringBuilder.appendPrizes(lottery: Lottery) {
        lottery.result.entries.sortedBy { it.key.value }
            .filterNot { it.key == Prize.NONE }
            .forEach { (prize, count) ->
                append("${prize.matchCount} Matches")
                if (prize == Prize.SECOND) append(" + Bonus Ball")
                append(" (${prize.value.toMoneyExpression()} KRW) - $count tickets\n")
            }
    }

    private fun Int.toMoneyExpression(): String {
        return "%,d".format(this)
    }
}
