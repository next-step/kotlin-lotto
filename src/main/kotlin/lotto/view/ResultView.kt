package lotto.view

import lotto.domain.LottoMatchResult
import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.domain.PurchasedLotteries

object ResultView {

    private const val PURCHASE_RESULT_MESSAGE = "개를 구매했습니다."
    private const val RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다."
    private const val BENEFIT_MESSAGE = " (기준이 1이기 때문에 결과적으로 %s임)"
    private const val WINNING_STATISTICS_RESULT_MESSAGE = "%s개 일치%s (%s원) - %s개"
    private const val EMPTY_MESSAGE = ""
    private const val BONUS_BALL_MESSAGE = ", 보너스 볼 일치"

    private val WINNING_STATISTICS_MESSAGE = """
        
        당첨 통계
        ---------
    """.trimIndent()

    fun printPurchaseResult(purchasedLotteries: PurchasedLotteries) {
        println(message = "${purchasedLotteries.size}$PURCHASE_RESULT_MESSAGE")

        purchasedLotteries.forEach { println(message = it.toString()) }
    }

    fun printLottoResult(lottoResult: LottoResult) {
        println(message = WINNING_STATISTICS_MESSAGE)

        LottoRank.values()
            .filter { it != LottoRank.MISS }
            .sortedDescending()
            .forEach { printWinningStatisticsResult(lottoRank = it, lottoResult = lottoResult) }

        println(
            message = RATE_OF_RETURN_MESSAGE.format(lottoResult.revenue.rateOfReturn) +
                BENEFIT_MESSAGE.format(lottoResult.benefitType.exposureName),
        )
    }

    private fun printWinningStatisticsResult(lottoRank: LottoRank, lottoResult: LottoResult) {
        println(
            message = WINNING_STATISTICS_RESULT_MESSAGE.format(
                lottoRank.lottoMatchResult,
                lottoRank.lottoMatchResult.getBonusBallMessage(),
                lottoRank.winningMoney,
                lottoResult.countNumberOfHit(lottoRank = lottoRank),
            ),
        )
    }

    private fun LottoMatchResult.getBonusBallMessage() = if (this.hasBonusBallCondition()) {
        BONUS_BALL_MESSAGE
    } else {
        EMPTY_MESSAGE
    }
}
