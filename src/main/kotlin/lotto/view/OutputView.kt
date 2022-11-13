package lotto.view

import lotto.dto.StatisticResult

class OutputView {

    companion object {
        fun printPurchase(purchaseCount: Int) {
            println("${purchaseCount}개를 구매했습니다.")
        }

        fun printLottoNumbers(lottoNumberList: List<Set<Int>>) {
            lottoNumberList.forEach {
                println(it.joinToString(separator = ", ", prefix = "[", postfix = "]"))
            }
            println()
        }

        fun printStatistics(statistics: List<StatisticResult>, profitRate: Double) {
            println("당첨 통계")
            println("---------")
            statistics.forEach {
                println("${it.lottoResult.matchCount}개 일치 (${it.lottoResult.winningMoney}원)- ${it.count}개")
            }
            println("총 수익률은 ${profitRate}입니다.")
        }
    }
}