package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoTicket

class ResultView {
    fun printBuyTickets(tickets: List<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        println(
            tickets.joinToString(
                separator = "\n",
                prefix = "",
                postfix = "",
            ),
        )
    }

    fun printTicket(ticket: LottoTicket) {
        println(ticket)
    }

    fun printResult(lottoResult: LottoResult) {
        println("당첨 통계\n---------")

        println("3개 일치 (5000원)- ${lottoResult.fourth}개")
        println("4개 일치 (50000원)- ${lottoResult.third}개")
        println("5개 일치 (1500000원)- ${lottoResult.second}개")
        println("6개 일치 (2000000000원)- ${lottoResult.first}개")
        println("총 수익률은 ${lottoResult.returnRate}입니다.(기준이 1이기 때문에 결과적으로 ${lottoResult.rateResultString}라는 의미임)")
    }
}
