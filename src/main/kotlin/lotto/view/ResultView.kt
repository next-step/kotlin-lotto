package lotto.view

import lotto.model.Lotto
import lotto.model.Prize

object ResultView {

    fun printPurchasedLottoNumbers(manualLotto: List<Lotto>, autoLotto: List<Lotto>) {
        println("수동으로 ${manualLotto.size}장, 자동으로 ${autoLotto.size}장을 구매했습니다.")
        manualLotto.map { println(it.numbers) }
        autoLotto.map { println(it.numbers) }
        println()
    }

    fun printWinnerStatistics(prizeHistory: List<Prize>) {
        println("당첨 통계")
        println("---------")
        val groupedPrizeByMatchCount = prizeHistory.groupBy { it.matchCount }
        println("${Prize.FOURTH.matchCount}개 일치 (${Prize.FOURTH.price}원) - ${groupedPrizeByMatchCount[Prize.FOURTH.matchCount]?.size ?: 0}개")
        println("${Prize.THIRD.matchCount}개 일치 (${Prize.THIRD.price}원) - ${groupedPrizeByMatchCount[Prize.THIRD.matchCount]?.size ?: 0}개")
        println("${Prize.SECOND.matchCount}개 일치 (${Prize.SECOND.price}원) - ${groupedPrizeByMatchCount[Prize.SECOND.matchCount]?.size ?: 0}개")
        println("${Prize.BETWEEN_FIRST_AND_SECOND.matchCount}개 일치, 보너스볼 일치 (${Prize.BETWEEN_FIRST_AND_SECOND.price}원) - ${groupedPrizeByMatchCount[Prize.BETWEEN_FIRST_AND_SECOND.matchCount]?.size ?: 0}개")
        println("${Prize.FIRST.matchCount}개 일치 (${Prize.FIRST.price}원) - ${groupedPrizeByMatchCount[Prize.FIRST.matchCount]?.size ?: 0}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${rateOfReturn}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
