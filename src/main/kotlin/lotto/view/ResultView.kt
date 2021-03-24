package lotto.view

import lotto.domain.LottoEachCountCalculator
import lotto.domain.LottoRanks
import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.view.ouput.LottoRate

class ResultView() {
    fun printLotto(lottoTickets: LottoTickets) {
        lottoTickets.forEach { println(it) }
    }

    fun printWon(lottoRanks: LottoRanks) {
        val wonRank = Rank.getWonRank()

        wonRank.forEach {
            println("${it.matchCondition} (${it.amount}원)- ${lottoRanks[it] ?: 0}")
        }
    }

    fun printRate(lottoRate: LottoRate) {
        print("총 수익률은 ${"%.2f".format(lottoRate.rate)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    fun printEachTypeCount(lottoEachCountCalculator: LottoEachCountCalculator) {
        val manualCount = lottoEachCountCalculator.manualCount
        val autoCount = lottoEachCountCalculator.autoCount

        println("수동으로 ${manualCount}장, 자동으로 ${autoCount}개를 구매했습니다.")
    }
}
