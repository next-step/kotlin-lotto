package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.result.LottoResult
import lotto.domain.ticket.LottoTicket
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.WinningBoard
import lotto.domain.value.Price

fun showLottoTickets(tickets: LottoTickets) {
    println("수동: ${tickets.manualSize()} 자동:${tickets.automaticSize()}개 구매")
    tickets.tickets
        .showTickets()
}

private fun Iterable<LottoTicket>.showTickets() {
    forEach {
        it.numbers.showNumbers()
    }
}

private fun Iterable<LottoNumber>.showNumbers() {
    println(joinToString(separator = ",", prefix = "[", postfix = "]", transform = { it.number.toString() }))
}

fun showResultStatic(result: LottoResult, price: Price) {
    println("당첨 통계")
    println("================")
    result.result().showResult()
    println("총 수익률은 ${result.calculateProfit(price)}")
}

private fun Map<WinningBoard, Int>.showResult() {
    forEach { (key, value) ->
        println("${key.matchCount}개 일치 (${key.reward}원) - ${value}개")
    }
}
