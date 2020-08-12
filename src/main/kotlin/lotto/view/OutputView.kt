package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoResults
import lotto.domain.LottoTickets
import java.math.BigDecimal

fun printLottoTickets(manualTicketCount: Int, tickets: LottoTickets) {
    println("수동으로 ${manualTicketCount}장, 자동으로 ${tickets.size() - manualTicketCount}개를 구매했습니다.")
    println(tickets)
}

fun printLottoResults(lottoResults: LottoResults) {
    for (result in LottoResult.values()) {
        printLottoResult(result, lottoResults.countOf(result))
    }
}

private fun printLottoResult(result: LottoResult, size: Int) {
    if (result == LottoResult.LOSE) return
    if (result == LottoResult.SECOND) {
        println("5개 일치, 보너스 볼 일치(${result.prize}원)- ${size}개")
        return
    }
    println("${getMatchCount(result)}개 일치, (${result.prize}원)- ${size}개")
}

private fun getMatchCount(result: LottoResult) = when (result) {
    LottoResult.FIRST -> 6
    LottoResult.SECOND, LottoResult.THIRD -> 5
    LottoResult.FOURTH -> 4
    LottoResult.FIFTH -> 3
    else -> 0
}

fun printEarnRatio(ratio: BigDecimal) {
    println("총 수익률은 %.2f 입니다.".format(ratio))
}
