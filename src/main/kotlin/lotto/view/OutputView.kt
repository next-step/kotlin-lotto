package lotto.view

import lotto.domain.LottoTicket

object OutputView {

    fun printLottoTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.lottoNumbers.map { it -> it.number }) }
    }
}
