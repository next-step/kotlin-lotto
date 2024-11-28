package lotto.presentation

import lotto.core.LottoWinningStatistics
import lotto.core.Lottos
import lotto.core.WinningRank

object ResultView {
    fun printLottos(lottos: Lottos) {
        val stringBuffer = StringBuffer()

        stringBuffer.append(lottos.size)
        stringBuffer.append(STR_PURCHASED_COUNT)
        stringBuffer.append(STR_NEW_LINE)
        lottos.forEach {
            stringBuffer.append(it.numbers.joinToString(",", "[", "]"))
            stringBuffer.append(STR_NEW_LINE)
        }

        println(stringBuffer.toString())
    }

    fun printWinningStatistics(winningStatistics: LottoWinningStatistics) {
        val stringBuffer = StringBuffer()
        stringBuffer.append(STR_WINNING_STATISTICS)
        stringBuffer.append(STR_NEW_LINE)
        stringBuffer.append(STR_SEPARATOR)
        stringBuffer.append(STR_NEW_LINE)

        winningStatistics.lottoResult.winningRankCount.filter { (it.key != WinningRank.NOTHING) }
            .map {
                stringBuffer.append(it.key.winningCount)
                stringBuffer.append(STR_MATCH)
                stringBuffer.append(it.key.winningAmount)
                stringBuffer.append(STR_AMOUNT)
                stringBuffer.append(it.value)
                stringBuffer.append(STR_COUNT)
                stringBuffer.append(STR_NEW_LINE)
            }

        stringBuffer.append("총 수익률은 ")
        stringBuffer.append(winningStatistics.yieldRate)
        stringBuffer.append("입니다.")
        stringBuffer.append(if (winningStatistics.yieldRate < 1) STR_PROFIT_IS_LOSS else STR_PROFIT_IS_GOOD)

        println(stringBuffer.toString())
    }

    private const val STR_PURCHASED_COUNT = "개를 구매하였습니다."
    private const val STR_NEW_LINE = "\n"
    private const val STR_WINNING_STATISTICS = "당첨 통계"
    private const val STR_SEPARATOR = "---------"
    private const val STR_MATCH = "개 일치("
    private const val STR_AMOUNT = "원) - "
    private const val STR_COUNT = "개"
    private const val STR_PROFIT_IS_LOSS = "기준이 1이기 때문에 결과적으로 손해라는 의미임"
    private const val STR_PROFIT_IS_GOOD = "기준이 1이기 때문에 결과적으로 손해는 아니라는 의미임"
}
