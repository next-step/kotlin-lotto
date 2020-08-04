package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoTicket

fun printLottoTickets(tickets: List<LottoTicket>) {
    println("${tickets.size}개를 구매했습니다.")
    tickets.forEach { println(it.toString()) }
}

fun printLottoResults(results: List<LottoResult>) {
    for (result in LottoResult.values()) {
        printLottoResult(result, results.filter { it == result }.size)
    }
}

private fun printLottoResult(result: LottoResult, size: Int) {
    if (result == LottoResult.LOSE) return
    println("${result.matchCount}개 일치 (${result.prize})- ${size}개")
}

fun printEarnRatio(ratio: Double) {
    println("총 수익률은 %.2f 입니다.".format(ratio))
}
