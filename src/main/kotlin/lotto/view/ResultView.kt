package lotto.view

import lotto.domain.LottoTicket

object ResultView {

    fun printTicketAmount(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun printTicketBundle(ticketBundle: List<LottoTicket>) {
        repeat(ticketBundle.size) {
            println("${ticketBundle[it].numbers}")
        }
    }

    fun printRateOfReturn(rate: Float) {
        println("총 수익률은 ${rate}입니다.")
    }
}
