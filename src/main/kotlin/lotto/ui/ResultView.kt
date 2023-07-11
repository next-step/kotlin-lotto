package lotto.ui

import lotto.domain.LottoTicket
import lotto.domain.MatchResult
import lotto.domain.Money
import lotto.domain.Rank

object ResultView {
    fun printPurchasedTicket(lottoTicket: LottoTicket) {
        println("${lottoTicket.countOfLotto} 개 구매했습니다")
        lottoTicket.lottos.map { lotto ->
            lotto.numbers.map { it.value }
        }.forEach {
            println(it)
        }
    }

    fun printStatistics(matchResult: MatchResult, money: Money) {
        println("당첨 통계")
        println("---------")
        Rank.values().forEach {
            printRank(it, matchResult)
        }
        val rateOfReturn = matchResult.rateOfReturn(money)
        val benefitOutcome = BenefitOutcome.from(rateOfReturn)
        println("총 수익률은 $rateOfReturn 입니다.(기준이 1이기 때문에 결과적으로 ${benefitOutcome.description}라는 의미임)")
    }

    private fun printRank(it: Rank, matchResult: MatchResult) {
        if (it == Rank.SECOND) {
            println("${it.count}개 일치, 보너스 볼 일치 (${it.winningAmount.value}원) - ${matchResult.countOf(it)}개")
            return
        }
        println("${it.count}개 일치 (${it.winningAmount.value}원) - ${matchResult.countOf(it)}개")
    }
}
