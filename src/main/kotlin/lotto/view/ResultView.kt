package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatistics

object ResultView {
    private const val PRINT_BUY_LOTTO_COUNT = "개를 구매했습니다."

    fun printBuyLottoCount(count: Int) {
        println("$count" + PRINT_BUY_LOTTO_COUNT)
    }

    fun printBuyLottoNumber(lottoNumbers: List<Lotto>) {
        lottoNumbers.forEach { lotto -> println(lotto.lottoNumber) }
        println()
    }

    fun printWinningStatistics(lottoNumbers: List<Lotto>, winningLottoNumbers: List<Int>, earningRate: Double) {
        println()
        println("당첨 통계")
        println("---------")

        val countToMoneyMap = mapOf(3 to 5000, 4 to 50000, 5 to 150000, 6 to 2000000000)

        countToMoneyMap.forEach { countToMoney ->
            val countSize = LottoStatistics.getLottoWinningCountOfLottoRank(lottoNumbers, winningLottoNumbers, countToMoney.key)
            println("${countToMoney.key}개 일치 (${countToMoney.value}원)- ${countSize}개")
        }
        println("총 수익률은 ${earningRate}입니다.")
    }
}
