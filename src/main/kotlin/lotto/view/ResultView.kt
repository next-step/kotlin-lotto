package lotto.view

import lotto.common.DoubleNumber
import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoStatisticsResult
import lotto.domain.LottoStatisticsTotal

class ResultView {

    fun printLottoList(manualLottoList: List<Lotto>, autoLottoList: List<Lotto>) {
        println("수동으로 ${manualLottoList.size}개, 자동으로 ${autoLottoList.size}개를 구매했습니다.")
        manualLottoList.forEach {
            printLotto(it)
        }
        autoLottoList.forEach {
            printLotto(it)
        }
        emptyLine()
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers)
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
            val hitCount = it.lottoRank.hitCount
            val prizeMoney = it.lottoRank.prizeMoney
            val winLottoCount = it.winLottoCount
            println("${hitCount}개 일치${printIfSecondPrize(it.lottoRank)} (${prizeMoney}원) - ${winLottoCount}개")
        }
    }

    private fun printIfSecondPrize(lottoRank: LottoRank): String {
        if (lottoRank.hasBonusNumber) {
            return ", 보너스 볼 일치"
        }
        return ""
    }

    private fun printEarningRate(earningRate: DoubleNumber) {
        print("총 수익률은 ${earningRate}입니다. ")
        if (earningRate.isGreaterThanEquals(DoubleNumber(1.0))) {
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
