package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.domain.Rank

object ResultView {
    fun printBuyTickets(
        manualCount: Int,
        autoCount: Int,
        tickets: List<LottoTicket>,
    ) {
        println("수동으로 ${manualCount}장, 자동으로 ${autoCount}개를 구매했습니다.")
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

        println("3개 일치 (5000원)- ${lottoResult.rankMap[Rank.FIFTH] ?: 0}개")
        println("4개 일치 (50000원)- ${lottoResult.rankMap[Rank.FOURTH] ?: 0}개")
        println("5개 일치 (1500000원)- ${lottoResult.rankMap[Rank.THIRD]}개")
        println("5개 일치,보너스 볼 일치(30000000원)- ${lottoResult.rankMap[Rank.SECOND] ?: 0}개")
        println("6개 일치 (2000000000원)- ${lottoResult.rankMap[Rank.FIRST] ?: 0}개")
        println("총 수익률은 ${lottoResult.returnRate}입니다.(기준이 1이기 때문에 결과적으로 ${lottoResult.rateResult.koreanText}라는 의미임)")
    }
}
