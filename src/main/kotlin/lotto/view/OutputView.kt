package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoResults
import lotto.domain.LottoTickets
import java.math.BigDecimal

fun printLottoTickets(tickets: LottoTickets) {
    println("${tickets.size()}개를 구매했습니다.")
    println(tickets)
}

fun printLottoResults(lottoResults: LottoResults) {
    for (result in LottoResult.values()) {
        printLottoResult(result, lottoResults.countOf(result))
    }
}

private fun printLottoResult(result: LottoResult, size: Int) {
    if (result == LottoResult.LOSE) return
    if (result == LottoResult.SECOND_BONUS) {
        println("${result.matchCount}개 일치, 보너스 볼 일치(${result.prize}원)- ${size}개")
        return
    }
    println("${result.matchCount}개 일치, (${result.prize}원)- ${size}개")
}

fun printEarnRatio(ratio: BigDecimal) {
    println("총 수익률은 %.2f 입니다.".format(ratio))
}
