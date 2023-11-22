package lotto.view

import lotto.data.Lotto
import lotto.data.LottoRanking
import lotto.domain.LottoCalculator

object OutputView {

    private const val TXT_WINNING_STATS = "당첨 통계"
    private const val TXT_PROFIT_COMMENT = "기준이 1이기 때문에 결과적으로 이득이라는 의미임"
    private const val TXT_LOSS_COMMENT = "기준이 1이기 때문에 결과적으로 손해라는 의미임"
    private const val DIVIDING_LINE = "---------"

    fun showLottoList(lottoList: List<Lotto>, manualGameTimes: Int) {
        val autoGameTimes = LottoCalculator.getAutoTimes(lottoList.size, manualGameTimes)

        println("수동으로 ${manualGameTimes}장, 자동으로 ${autoGameTimes}장 구매했습니다.")
        lottoList.forEach {
            println(it.selectNumbers)
        }
        println()
    }

    fun showWinningStatus(winningStatus: Map<LottoRanking, Int>, winningRate: Float) {
        println(TXT_WINNING_STATS)
        printDivingLine()

        printStatus(LottoRanking.FifthPlace, winningStatus)
        printStatus(LottoRanking.FourthPlace, winningStatus)
        printStatus(LottoRanking.ThirdPlace, winningStatus)
        printStatus(LottoRanking.SecondPlace, winningStatus)
        printStatus(LottoRanking.FirstPlace, winningStatus)
        val comment = if (winningRate > 1) TXT_PROFIT_COMMENT else TXT_LOSS_COMMENT

        println("총 수익률은 ${winningRate}입니다. ($comment)")
    }

    private fun printStatus(lottoRanking: LottoRanking, winningStatus: Map<LottoRanking, Int>) {
        val matchingLottoCnt = winningStatus.getOrDefault(lottoRanking, 0)
        val matchingNumberCnt = lottoRanking.matchingNumberCnt
        val matchingPrice = lottoRanking.price
        if (lottoRanking == LottoRanking.SecondPlace) {
            println("{${matchingNumberCnt}개 일치, 보너스 볼 일치(${matchingPrice}원)- ${matchingLottoCnt}개}")
        } else {
            println("{${matchingNumberCnt}개 일치 (${matchingPrice}원)- ${matchingLottoCnt}개}")
        }
    }

    private fun printDivingLine() {
        println(DIVIDING_LINE)
    }
}
