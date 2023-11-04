package lotto.view

import lotto.business.LottoTicket

object LottoPurchaseSummaryPrinter {
    fun print(lottoTickets: List<LottoTicket>) {
        println("${lottoTickets.size}개를 구매했습니다.")
        lottoTickets.forEach { println(it.lottoNumbers) }
        println()
    }
}
