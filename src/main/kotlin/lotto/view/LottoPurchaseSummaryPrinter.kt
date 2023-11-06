package lotto.view

import lotto.business.LottoTicket

object LottoPurchaseSummaryPrinter {
    fun print(lottoTickets: List<LottoTicket>) {
        println("${lottoTickets.size}개를 구매했습니다.")
        lottoTickets.forEach { it: LottoTicket -> println(it.lottoNumbers.map { it.number.toString() }) }
        println()
    }
}
