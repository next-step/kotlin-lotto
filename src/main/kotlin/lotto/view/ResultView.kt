package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoStatisticsResult
import lotto.domain.LottoStatisticsTotal

class ResultView {

    fun printLotto(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
        emptyLine()
    }

    fun printLottoStatistics(statisticsResult: LottoStatisticsTotal) {
        emptyLine()
        println(STATISTICS_GUIDE)
        println(SPLIT_LINE)
        printWinStatisticsResult(statisticsResult.winLottoStatisticsResult)
        printEarningRate(statisticsResult.earningRate)
    }

    private fun printWinStatisticsResult(winLottoStatisticsResult: List<LottoStatisticsResult>) {
        winLottoStatisticsResult.forEach {
            val hitCount = it.hitCount
            val prizeMoney = it.prizeMoney
            val winLottoCount = it.winLottoCount
            println("${hitCount}개 일치 (${prizeMoney}원) - ${winLottoCount}개")
        }
    }

    private fun printEarningRate(earningRate: Double) {
        print("총 수익률은 ${earningRate}입니다. ")
        if (earningRate > 1) {
            println("(기준이 1이기 때문에 이익입니다.)")
            return
        }
        println("(기준이 1이기 때문에 손해입니다.)")
    }

    private fun emptyLine() {
        println()
    }

    companion object {
        private const val STATISTICS_GUIDE = "당첨 통계"
        private const val SPLIT_LINE = "---------"
    }
}
