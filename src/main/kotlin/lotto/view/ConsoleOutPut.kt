package lotto.view

import lotto.controller.dto.WinningStatistic

class ConsoleOutPut {
    fun printPurchasedLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }

    fun printResult(winningStatisticsDto: WinningStatistic, rateOfReturn: Double) {
        println("당첨 통계")
        println("---------")

        winningStatisticsDto.winningStatistic.sortedBy { it.first.matchedCount }
            .asSequence()
            .filter { it.first.matchedCount != 0 }
            .forEach { (winningStatistic, winningPrizeCount) ->
                println("${winningStatistic.matchedCount}개 일치 (${winningStatistic.prize}원)- ${winningPrizeCount.count}개")
            }

        println("총 수익률은 ${rateOfReturn}입니다.")
    }
}
