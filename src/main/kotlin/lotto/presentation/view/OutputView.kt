package lotto.presentation.view

import lotto.presentation.controller.EvaluateResponse
import lotto.presentation.controller.PurchaseResponse

object OutputView {
    fun drawLottoTicketsOutput(resp: PurchaseResponse) {
        drawPurchaseCount(resp.tickets.size)
        drawTickets(resp.tickets)
    }

    fun drawLottoResultOutput(resp: EvaluateResponse) {
        drawRankResult(resp.rankResult)
        drawEarningRate(resp.earningRate)
    }

    private fun drawPurchaseCount(count: Int) {
        println("$count 개를 구매 했습니다")
    }

    private fun drawTickets(tickets: List<List<Int>>) {
        tickets.forEach { println(it) }
    }

    private fun drawRankResult(rankResult: List<List<Int>>) {
        println(consoleIndicator)
        println(consoleBR)
        rankResult.forEach {
            consoleTableOutput
                .format(it[0], it[1], it[2])
                .also(::println)
        }
    }

    private fun drawEarningRate(earningRate: Double) {
        consoleEarnRateOutput
            .format(earningRate, if (earningRate > 1) "이익" else "손해")
            .also(::println)
    }

    private const val consoleIndicator = "당첨 통계"
    private const val consoleBR = "----------------------"
    private const val consoleTableOutput = "%d개 일치 (%d원)- %d개"
    private const val consoleEarnRateOutput = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)"
}
