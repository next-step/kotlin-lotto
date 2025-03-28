package lotto.view

import lotto.domain.Lottery
import lotto.domain.Lotto
import lotto.domain.Prize

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach {
            println("[${it.rawNumbers.joinToString(", ")}]")
        }
    }

    fun printWinningStatistics(lottery: Lottery) {
        println("\nWinning Statistics\n------------------")
        lottery.result.entries.sortedBy { it.key.value }
            .filterNot { it.key == Prize.NONE }
            .forEach { (prize, count) ->
                println("${prize.matchCount} Matches (${prize.value.toMoneyExpression()} KRW) - $count tickets")
            }

        println("Total return rate is %.2f (A rate below 1 means a loss)".format(lottery.returnRate))
    }

    private fun Int.toMoneyExpression(): String {
        return "%,d".format(this)
    }
}
