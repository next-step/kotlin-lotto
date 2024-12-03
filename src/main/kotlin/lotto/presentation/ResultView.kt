package lotto.presentation

import lotto.core.LottoPurchaseCount
import lotto.core.LottoResult
import lotto.core.Lottos
import lotto.core.WinningRank

object ResultView {
    fun printLottos(
        lottos: Lottos,
        lottoPurchaseCount: LottoPurchaseCount,
    ) {
        val stringBuffer = StringBuffer()
        stringBuffer.append(String.format(STR_PURCHASED_COUNT, lottoPurchaseCount.manualLottoCount, lottoPurchaseCount.autoLottoCount()))
        stringBuffer.append(STR_NEW_LINE)

        lottos.forEach {
            stringBuffer.append(it.numbers.joinToString(",", "[", "]"))
            stringBuffer.append(STR_NEW_LINE)
        }

        println(stringBuffer.toString())
    }

    fun printLottoResult(lottoResult: LottoResult) {
        val stringBuffer = StringBuffer()
        stringBuffer.append(STR_WINNING_STATISTICS)
        stringBuffer.append(STR_NEW_LINE)
        stringBuffer.append(STR_SEPARATOR)
        stringBuffer.append(STR_NEW_LINE)

        WinningRank.entries
            .filter { it != WinningRank.NOTHING }
            .forEach { rank ->
                appendWinningCount(rank, lottoResult.winningRankCount.getOrDefault(rank, 0), stringBuffer)
            }
        println(stringBuffer.toString())
    }

    fun printYieldRate(
        lottoResult: LottoResult,
        lottos: Lottos,
    ) {
        val yieldRate = lottoResult.calculateYield(lottos.size)

        val stringBuffer = StringBuffer()
        stringBuffer.append("총 수익률은 ")
        stringBuffer.append(yieldRate)
        stringBuffer.append("입니다.")
        stringBuffer.append(if (yieldRate < 1) STR_PROFIT_IS_LOSS else STR_PROFIT_IS_GOOD)
        println(stringBuffer.toString())
    }

    private fun appendWinningCount(
        rank: WinningRank,
        count: Int,
        stringBuffer: StringBuffer,
    ) {
        stringBuffer.append(rank.winningCount)
        stringBuffer.append(STR_MATCH)
        if (rank.matchBonus) {
            stringBuffer.append(STR_MATCH_BONUS_BALL)
        }
        stringBuffer.append(STR_LEFT_PARENTHESIS)
        stringBuffer.append(rank.winningAmount)
        stringBuffer.append(STR_AMOUNT)
        stringBuffer.append(count)
        stringBuffer.append(STR_COUNT)
        stringBuffer.append(STR_NEW_LINE)
    }

    private const val STR_PURCHASED_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다."
    private const val STR_NEW_LINE = "\n"
    private const val STR_WINNING_STATISTICS = "당첨 통계"
    private const val STR_SEPARATOR = "---------"
    private const val STR_MATCH = "개 일치"
    private const val STR_LEFT_PARENTHESIS = "("
    private const val STR_AMOUNT = "원) - "
    private const val STR_COUNT = "개"
    private const val STR_PROFIT_IS_LOSS = "기준이 1이기 때문에 결과적으로 손해라는 의미임"
    private const val STR_PROFIT_IS_GOOD = "기준이 1이기 때문에 결과적으로 손해는 아니라는 의미임"
    private const val STR_MATCH_BONUS_BALL = ", 보너스 볼 일치"
}
