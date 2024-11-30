package lotto.view

import lotto.domain.data.Lotto
import lotto.domain.data.LottoWinPlace
import java.math.BigDecimal

object ResultView {
    fun printTotalPurchaseCount(count: Int) {
        println("\n$count 개를 구매 했습니다.")
    }

    fun printLottoNumbers(list: List<Lotto>) {
        list.forEach { println(it) }
    }

    fun printLottoResult(resultMap: Map<LottoWinPlace, Int>) {
        println("\n당첨 통계\n---------")
        LottoWinPlace.getPlacesFromLowest().forEach { winPlace ->
            println("${winPlace.matchingNumberCount}개 일치 (${winPlace.prizeMoney}원) - ${resultMap[winPlace]}")
        }
    }

    fun printProfitRate(profitRate: BigDecimal) {
        println("\n총 수익률은 $profitRate 입니다.\n")
    }
}
