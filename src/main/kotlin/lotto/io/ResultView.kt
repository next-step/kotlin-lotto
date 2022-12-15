package lotto.io

import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.MatchResult
import lotto.domain.PlayResults
import lotto.domain.PurchaseItem

object ResultView {
    private const val LINE_FEED = "\n"
    private const val MATCHED_RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원) - %d개"
    private const val SECOND_PLACE_RESULT_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개"
    private const val FINAL_PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다."
    private const val PURCHASE_LOTTO_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.$LINE_FEED"
    private const val WINNING_STATISTICS_TITLE = "${LINE_FEED}당첨 통계$LINE_FEED---------$LINE_FEED"

    fun printPurchaseItem(purchaseItem: PurchaseItem) {
        val stringBuilder = StringBuilder()
        formatPurchaseCount(purchaseItem.tryCount, stringBuilder)
        formatPurchaseLottos(purchaseItem.lottos, stringBuilder)

        println(stringBuilder.toString())
    }

    private fun formatPurchaseCount(tryCount: Int, stringBuilder: StringBuilder) {
        val purchaseLottoCountMessage = PURCHASE_LOTTO_COUNT_MESSAGE_FORMAT.format(tryCount)
        stringBuilder.append(purchaseLottoCountMessage)
    }

    private fun formatPurchaseLottos(lottos: Lottos, stringBuilder: StringBuilder) {
        lottos.elements.forEach {
            formatPurchaseEachLotto(it, stringBuilder)
        }
    }

    private fun formatPurchaseEachLotto(lotto: Lotto, stringBuilder: StringBuilder) {
        val purchaseLotto = lotto.elements
            .map { it.value }
            .toList()
        stringBuilder.appendLine(purchaseLotto)
    }

    fun printWinningStatistics(playResults: PlayResults) {
        val stringBuilder = StringBuilder()
        formatWinningStatisticsTitle(stringBuilder)
        formatMatchedRankMessage(stringBuilder, playResults)
        formatProfitRateMessage(stringBuilder, playResults)

        println(stringBuilder.toString())
    }

    private fun formatWinningStatisticsTitle(stringBuilder: StringBuilder) =
        stringBuilder.append(WINNING_STATISTICS_TITLE)

    private fun formatMatchedRankMessage(stringBuilder: StringBuilder, playResults: PlayResults) {
        playResults.aggregations
            .entries
            .forEach { formatMatchedRankMessage(stringBuilder, it) }
        stringBuilder.appendLine()
    }

    private fun formatMatchedRankMessage(stringBuilder: StringBuilder, entry: Map.Entry<MatchResult, Int>) {
        val matchResult = entry.key
        val winningCount = entry.value
        if (matchResult.isSecondPlace()) {
            formatSecondRankMessage(stringBuilder, matchResult, winningCount)
        } else {
            formatMatchedRankMessageByRank(stringBuilder, matchResult, winningCount)
        }
    }

    private fun formatSecondRankMessage(stringBuilder: StringBuilder, matchResult: MatchResult, winningCount: Int) {
        stringBuilder.append(SECOND_PLACE_RESULT_MESSAGE_FORMAT.format(matchResult.matchCount, matchResult.reward, winningCount))
        stringBuilder.appendLine()
    }

    private fun formatMatchedRankMessageByRank(stringBuilder: StringBuilder, matchResult: MatchResult, winningCount: Int) {
        stringBuilder.append(MATCHED_RESULT_MESSAGE_FORMAT.format(matchResult.matchCount, matchResult.reward, winningCount))
        stringBuilder.appendLine()
    }

    private fun formatProfitRateMessage(stringBuilder: StringBuilder, playResults: PlayResults) {
        stringBuilder.append(FINAL_PROFIT_RATE_MESSAGE_FORMAT.format(playResults.profitRate))
        stringBuilder.appendLine()
    }
}
