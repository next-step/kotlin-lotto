package lotto.view

import lotto.controller.EndLottoResponse
import lotto.controller.PurchaseResponse
import lotto.domain.LottoTicket

object OutputView {
    private const val PURCHASE_COUNT_MSG = "%d개를 구매했습니다"
    private const val EARNING_RATE_MSG = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)"

    fun drawPurchaseOutput(response: PurchaseResponse) {
        val tickets = response.tickets
        drawPurchaseCount(tickets.count)
        drawTickets(tickets.tickets)
    }

    fun drawEarningRateOutput(response: EndLottoResponse) {
        val rate = response.result.earningRate
        val lossMessage = if (rate.isLoss()) "손해" else "손해가 아니"
        println(EARNING_RATE_MSG.format(response.result.earningRate, lossMessage))
    }

    private fun drawPurchaseCount(count: Int) {
        println(PURCHASE_COUNT_MSG.format(count))
    }

    private fun drawTickets(tickets: List<LottoTicket>) {
        tickets.forEach { println(it.numbers) }
    }
}
