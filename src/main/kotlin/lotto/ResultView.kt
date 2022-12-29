package lotto

import lotto.domain.Lotto
import lotto.domain.LottoRankResults
import lotto.model.Rank

object ResultView {

    fun printLotto(userLotto: Lotto) {
        println("${userLotto.numbers.size}개를 구매했습니다.")
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
}
