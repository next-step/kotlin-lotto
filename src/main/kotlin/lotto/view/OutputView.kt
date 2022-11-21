package lotto.view

import lotto.domain.LottoSummary

object OutputView {
    fun printSummary(lottoSummary: LottoSummary) {
        println("당첨 통계")
        println("---------")
        lottoSummary.winners.forEach { winner ->
            println("${winner.lottoInfo.matchCount}개 일치 (${winner.lottoInfo.amount}원)- ${winner.count}개")
        }
        println("총 수익률은 ${lottoSummary.rateOfReturn}입니다.")
    }
}
