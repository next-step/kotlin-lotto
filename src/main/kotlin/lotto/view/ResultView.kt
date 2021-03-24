package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.LottoWonNumbers
import lotto.domain.Rank
import lotto.view.input.AmountInput
import lotto.view.input.ManualCountInput

class ResultView() {
    fun printLotto(lottoTickets: LottoTickets) {
        lottoTickets.forEach { println(it) }
    }

    fun printWon(lottoTickets: LottoTickets, wonNumbers: LottoWonNumbers) {
        val matchByWonNumber = wonNumbers.match(lottoTickets)
        val wonRank = Rank.getWonRank()

        wonRank.forEach {
            println("${it.matchCondition} (${it.amount}원)- ${matchByWonNumber[it] ?: 0}")
        }
    }

    fun printRate(lottoTickets: LottoTickets, wonNumbers: LottoWonNumbers) {
        val matchByWonNumber = wonNumbers.match(lottoTickets)
        val rate: Double = (matchByWonNumber.sumAmount.toDouble() / (lottoTickets.size * 1000).toDouble())

        print("총 수익률은 ${"%.2f".format(rate)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    fun printEachTypeCount(amountInput: AmountInput, manualCountInput: ManualCountInput) {
        val manualCount = manualCountInput.lottoCount
        val autoCount = amountInput.lottoCount - manualCount

        println("수동으로 ${manualCount}장, 자동으로 ${autoCount}개를 구매했습니다.")
    }
}
