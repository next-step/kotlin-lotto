package lotto

import lotto.result.Rank
import lotto.result.WinningResult
import lotto.store.PurchaseRequest
import lotto.ticket.IssuedLottoTickets
import lotto.ticket.LottoTicket

fun printLottoTickets(issuedTickets: IssuedLottoTickets) {
    val tickets = issuedTickets.lottoTickets
    println("${tickets.size}개 구매")
    tickets.forEach { printLottoTicket(it) }
}

private fun printLottoTicket(lottoTicket: LottoTicket) {
    val txTicket = lottoTicket.lottoNumbers.joinToString(
        separator = ",",
        prefix = "[",
        postfix = "]"
    )

    println(txTicket)
}

fun printResultStatic(request: PurchaseRequest, result: WinningResult) {
    println("당첨 통계")
    println("================")
    printStatics(result)
    println("총 수익률은 ${result.totalPrize.calculateYield(request.amount)}")
}

private fun printStatics(result: WinningResult) {
    Rank.WINNING_RANKS.forEach {
        println("${it.matchCount}개 일치 (${it.prizeAmount}원) - ${result.findRankCount(it)}개")
    }
}
