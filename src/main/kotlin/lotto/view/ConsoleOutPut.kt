package lotto.view

import lotto.controller.dto.WinningPrizeCount
import lotto.controller.dto.WinningPrizeInfo
import lotto.controller.dto.WinningStatistic

class ConsoleOutPut {
    fun printPurchasedLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }

    fun printWinningPrize(winningStatisticsDto: WinningStatistic, rateOfReturn: Double) {
        println("당첨 통계")
        println("---------")

        winningStatisticsDto.winningStatistic.sortedWith(compareBy({ it.first.matchedCount }, { it.first.prize }))
            .asSequence()
            .filter { it.first.matchedCount != 0 }
            .forEach { (winningStatistic, winningPrizeCount) -> printWinningPrize(winningStatistic, winningPrizeCount) }

        println("총 수익률은 ${rateOfReturn}입니다.")
    }

    private fun printWinningPrize(winningStatistic: WinningPrizeInfo, winningPrizeCount: WinningPrizeCount) {
        winningStatistic.takeIf { it.hasBonus }
            ?.let { println("${winningStatistic.matchedCount}개 일치, 보너스 볼 일치 (${winningStatistic.prize}원)- ${winningPrizeCount.count}개") }
            ?: println("${winningStatistic.matchedCount}개 일치 (${winningStatistic.prize}원)- ${winningPrizeCount.count}개")
    }
}
