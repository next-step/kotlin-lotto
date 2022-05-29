package lotto.view

import lotto.domain.LottoTicket

class OutputView {
    fun printTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.lottoNumbers.map { lottoNumber -> lottoNumber.number }.joinToString(", ", "[", "]"))
        }
    }

    fun printStat() {
        println("당첨 통계\n---------")
    }

    fun printRevenue() {
        println("총 수익률은 ${0.35}입니다.")
    }
}
