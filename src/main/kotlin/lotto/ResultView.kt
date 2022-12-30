package lotto

import lotto.domain.Lotto
import lotto.domain.LottoRankResults
import lotto.domain.LottoTicket
import lotto.model.Rank

object ResultView {

    fun printLotto(userLotto: Lotto) {
        userLotto.numbers.forEach { it.value.let(::println) }
        println()
    }

    fun printLottoPrizeResults(lottoRankResults: LottoRankResults) {
        println()
        println("당첨 통계")
        println("---------")
        Rank.values()
            .forEach {
                println("${it.matchCount}개 일치 (${it.prize}원) - ${lottoRankResults.count(it)}개")
            }
    }

    fun printLottoROIAnalysis(returnOnInvestment: Double) {
        println("총 수익률은 ${returnOnInvestment}%입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    fun printLottoTicket(ticket: LottoTicket) {
        println()
        println("수동으로 ${ticket.manualLottoNumbersSize}장, 자동으로 ${ticket.autoLottoNumbersSize}개를 구매했습니다.")
    }
}
