package lotto

import lotto.domain.LottoPrizeResults
import lotto.domain.Lotto
import lotto.model.LottoPrize

object ResultView {

    fun printLotto(userLotto: Lotto) {
        println("${userLotto.numbers.size}개를 구매했습니다.")
        userLotto.numbers.forEach { it.value.let(::println) }
        println()
    }

    fun printLottoPrizeResults(lottoPrizeResults: LottoPrizeResults) {
        println()
        println("당첨 통계")
        println("---------")
        LottoPrize.values()
            .forEach {
                println("${it.matchCount}개 일치 (${it.prize}원) - ${lottoPrizeResults.count(it)}개")
            }
    }

    fun printLottoROIAnalysis(returnOnInvestment: Double) {
        println("총 수익률은 ${returnOnInvestment}%입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
