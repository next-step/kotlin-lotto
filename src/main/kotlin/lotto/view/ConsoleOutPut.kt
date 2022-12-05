package lotto.view

import lotto.controller.dto.WinningStatistic

class ConsoleOutPut {
    fun printPurchasedLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }

    fun printResult(winningStatistic: WinningStatistic, rateOfReturn: Double) {
        println("당첨 통계")
        println("---------")

        winningStatistic.winningStatistic.sortedBy { it.first }
            .asSequence()
            .filter { it.first != 0 }
            .forEach { (matchedCount, prize, duplicatedMatchedCount) ->
                println("${matchedCount}개 일치 (${prize}원)- ${duplicatedMatchedCount}개")
            }

        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
