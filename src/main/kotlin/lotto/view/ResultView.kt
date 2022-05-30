package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoMatch

object ResultView {
    private const val PRINT_BUY_LOTTO_COUNT = "개를 구매했습니다."

    fun printBuyLottoCount(count: Int) {
        println("$count" + PRINT_BUY_LOTTO_COUNT)
    }

    fun printBuyLottoNumber(lottoNumbers: List<Lotto>) {
        lottoNumbers.forEach { lotto -> println(lotto.lottoNumber) }
        println()
    }

    fun printWinningStatistics(resultMap: Map<LottoMatch, Int>, earningRate: Double) {
        println()
        println("당첨 통계")
        println("---------")

        resultMap.toSortedMap().forEach { result ->
            println("${result.key.count}개 일치 (${result.key.prize}원)- ${result.value}개")
        }
        println("총 수익률은 ${earningRate}입니다.")
    }
}
