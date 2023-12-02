package specific.lotto.view

import specific.lotto.domain.BonusNumberCondition
import specific.lotto.domain.Rank
import specific.lotto.domain.Tickets
import specific.lotto.domain.WinningResult

object OutputView {
    fun printTickets(tickets: Tickets) {
        println("수동으로 ${tickets.manualTickets.size}장, 자동으로 ${tickets.autoTickets.size}개를 구매했습니다.")
        tickets.manualTickets.forEach {
            println(it.getSortedNumbers().map { it.value })
        }
        tickets.autoTickets.forEach {
            println(it.getSortedNumbers().map { it.value })
        }
    }

    fun printWinningResult(winningResult: WinningResult) {
        println("당첨 통계")
        println("---------")
        Rank.values()
            .filter { it.isWin }
            .forEach {
                println("${makeRankCondition(it)} (${it.prize}원- ${winningResult.aggregatedData[it]}개)")
            }
    }

    fun printReturnOnInvestment(returnOnInvestment: Double) {
        println(
            "총 수익률은 ${String.format("%.2f", returnOnInvestment)}입니다. (${makeProfitOrLossStatus(returnOnInvestment)})"
        )
    }

    private fun makeRankCondition(rank: Rank): String {
        if (!rank.isWin) {
            return "당첨되지 않음"
        }
        return "${rank.sameNumbersCount}개 일치${makeBonusNumberMatchStatus(rank.bonusNumberCondition)}"
    }

    private fun makeBonusNumberMatchStatus(bonusNumberCondition: BonusNumberCondition): String =
        when (bonusNumberCondition) {
            BonusNumberCondition.MATCH -> ", 보너스 볼 일치"
            else -> ""
        }

    private fun makeProfitOrLossStatus(returnOnInvestment: Double): String =
        "기준이 1이기 때문에 결과적으로 ${if (returnOnInvestment > 1) "이득이라는" else "손해라는"} 의미임"
}
