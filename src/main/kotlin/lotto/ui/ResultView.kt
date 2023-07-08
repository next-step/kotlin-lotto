package lotto.ui

import lotto.domain.LottoTicket
import lotto.domain.Match
import lotto.domain.MatchResult
import lotto.domain.Money

object ResultView {
    fun printPurchasedTicket(lottoTicket: LottoTicket) {
        println("${lottoTicket.size} 개 구매했습니다")
        lottoTicket.lottos.map { lotto ->
            lotto.numbers.map { it.value }
        }.forEach {
            println(it)
        }
    }

    fun printStatistics(matchResult: MatchResult, money: Money) {
        println("당첨 통계")
        println("---------")
        Match.values().forEach {
            println("${it.count}개 일치 (${it.winningAmount}원) - ${matchResult.countOf(it)}개")
        }
        println("총 수익률은 ${matchResult.rateOfReturn(money.intValue)}% 입니다.")
    }
}
