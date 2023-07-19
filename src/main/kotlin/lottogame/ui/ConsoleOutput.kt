package lottogame.ui

import lottogame.domain.GameMoney
import lottogame.domain.lotto.LottoTicket
import lottogame.domain.lotto.MatchResult
import lottogame.domain.rank.Rank

class ConsoleOutput : LottoGameOutput {
    override fun printPurchasedTicket(lottoTicket: LottoTicket) {
        println("수동으로 ${lottoTicket.countOfManualLotto}장, 자동으로 ${lottoTicket.countOfAutoLotto}개 구매했습니다")
        lottoTicket.lottos.map { lotto ->
            lotto.numbers.map { it.value }
        }.forEach {
            println(it)
        }
    }

    override fun printStatistics(matches: MatchResult, gameMoney: GameMoney) {
        println("당첨 통계")
        println("---------")
        Rank.values().forEach {
            printRank(it, matches)
        }
        val rateOfReturn = matches.rateOfReturn(gameMoney)
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
