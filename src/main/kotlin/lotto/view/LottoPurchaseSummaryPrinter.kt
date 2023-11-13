package lotto.view

import lotto.business.LottoTicket

object LottoPurchaseSummaryPrinter {
    fun print(manualTicketCount: Int, lottoTickets: List<LottoTicket>) {
        println("수동으로 ${manualTicketCount}장, 자동으로 ${lottoTickets.size}개를 구매했습니다.")
        lottoTickets.forEach { it: LottoTicket -> println(it.lottoNumbers.map { it.number.toString() }) }
        println()
    }
}
