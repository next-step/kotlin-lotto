package lotto.view

import lotto.domain.LottoTicket
import lotto.dto.LottoResult

object ResultView {
    fun showTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun showResult(result: LottoResult, purchaseAmount: Int) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (5000원)- ${result.getMatchCount(3)}개")
        println("4개 일치 (50000원)- ${result.getMatchCount(4)}개")
        println("5개 일치 (1500000원)- ${result.getMatchCount(5)}개")
        println("6개 일치 (2000000000원)- ${result.getMatchCount(6)}개")
        println("총 수익률은 ${result.calculateReturnRate(purchaseAmount.toDouble())}입니다.")
    }
}
