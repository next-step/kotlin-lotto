package lotto.view

import lotto.model.Lotto
import lotto.model.Prize

object ResultView {

    fun printPurchasedLottoNumbers(purchasedLotto: List<Lotto>) {
        println("${purchasedLotto.size}개를 구매했습니다.")
        purchasedLotto.map { println(it.numbers) }
        println()
    }

    fun printWinnerStatistics(prizeHistory: List<Prize>) {
        println("당첨 통계")
        println("---------")
        val groupedPrizeByMatchCount = prizeHistory.groupBy { it.matchCount }
        println("${Prize.FOURTH.matchCount}개 일치 (${Prize.FOURTH.price}원) - ${groupedPrizeByMatchCount[Prize.FOURTH.matchCount]?.size ?: 0}개")
        println("${Prize.THIRD.matchCount}개 일치 (${Prize.THIRD.price}원) - ${groupedPrizeByMatchCount[Prize.THIRD.matchCount]?.size ?: 0}개")
        println("${Prize.SECOND.matchCount}개 일치 (${Prize.SECOND.price}원) - ${groupedPrizeByMatchCount[Prize.SECOND.matchCount]?.size ?: 0}개")
        println("${Prize.FIRST.matchCount}개 일치 (${Prize.FIRST.price}원) - ${groupedPrizeByMatchCount[Prize.FIRST.matchCount]?.size ?: 0}개")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${rateOfReturn}입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
