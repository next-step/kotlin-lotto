package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank

object ResultView {
    private const val TEXT_DASH_REPEAT_COUNT = 9
    private const val TEXT_RESULT_PURCHASE_NUMBER = "%d개를 구매했습니다."
    private const val LOTTO_NUMBER_PREFIX = "["
    private const val LOTTO_NUMBER_POSTFIX = "]"
    private const val TEXT_RESULT_LOTTO = "당첨통계"
    private const val TEXT_DASH = "-"
    private const val TEXT_EMPTY = ""
    private const val LOTTO_NUMBER_SEPARATOR = ", "
    private const val TEXT_PRIZE_RESULT = "%d개 일치%s (%d원)- %d개"
    private const val TEXT_TOTAL_PROFIT_RATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)"
    private const val TEXT_MATCH_BONUS_NUMBER = ", 보너스 볼 일치"
    private const val TEXT_PROFIT = "이득"
    private const val TEXT_LOSS = "손해"
    private const val TEXT_BALANCE = "본전"

    fun printLotto(lottos: List<Lotto>) {
        println(TEXT_RESULT_PURCHASE_NUMBER.format(lottos.size))
        lottos.forEach { lotto ->
            println(
                lotto.joinToLottoNumbersString(
                    separator = LOTTO_NUMBER_SEPARATOR,
                    prefix = LOTTO_NUMBER_PREFIX,
                    postfix = LOTTO_NUMBER_POSTFIX,
                ),
            )
        }
        println()
    }

    fun printLottoResult(
        lottoResult: LottoResult,
        purchaseAmount: Int,
    ) {
        println()
        printLottoRanks(lottoResult)
        printLottoProfitRate(lottoResult, purchaseAmount)
    }

    private fun printLottoRanks(lottoResult: LottoResult) {
        println(TEXT_RESULT_LOTTO)
        println(TEXT_DASH.repeat(TEXT_DASH_REPEAT_COUNT))

        lottoResult.rankCounts.filter { it.key != LottoRank.UNRANKED }.forEach { (rank, count) ->
            val matchBonusText = if (rank == LottoRank.SECOND) TEXT_MATCH_BONUS_NUMBER else TEXT_EMPTY
            println(TEXT_PRIZE_RESULT.format(rank.matchCount, matchBonusText, rank.money, count))
        }
    }

    private fun printLottoProfitRate(
        lottoResult: LottoResult,
        purchaseAmount: Int,
    ) {
        val profitRate = lottoResult.calculateProfitRate(purchaseAmount)
        val profitRateResultText = findProfitRateResultText(profitRate)
        println(TEXT_TOTAL_PROFIT_RATE.format(profitRate, profitRateResultText))
    }

    private fun findProfitRateResultText(profitRate: Float): String =
        when {
            profitRate > 1f -> TEXT_PROFIT
            profitRate < 1f -> TEXT_LOSS
            else -> TEXT_BALANCE
        }
}
