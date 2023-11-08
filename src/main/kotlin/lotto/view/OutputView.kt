package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoStorage

object OutputView {

    private const val BUYING_MESSAGE_FORMAT = "%s개를 구매했습니다. 거스름돈은 %d원입니다."
    private const val LOTTO_FORMAT = "[%s]"
    private const val WINNING_STATISTICS_MESSAGE_FORMAT = """
        당첨 통계
        ---------
        %s
    """
    private const val MATCH_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개"
    private const val STANDARD_RATE = 1
    private const val EARNING_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.(기준이 ${STANDARD_RATE}이기 때문에 결과적으로 %s(이)라는 의미임)"
    private const val WIN = "이득"
    private const val LOSE = "손해"

    fun printLottos(lottoStorage: LottoStorage, change: Int) {
        val lottoCount = lottoStorage.getLottoCount()
        println(String.format(BUYING_MESSAGE_FORMAT, lottoCount, change))
        lottoStorage.lottos.forEach {
            val lottoNumbers = it.numbers.joinToString(", ")
            println(String.format(LOTTO_FORMAT, lottoNumbers))
        }
    }

    fun printLottoResult(lottoMatchResult: LottoStorage.LottoMatchResult) {
        val statisticsMessage = createStatisticMessage(lottoMatchResult.result)
        val earningRateMessage = createEarningRateMessage(lottoMatchResult.earningRate)

        println(statisticsMessage)
        println(earningRateMessage)
    }

    private fun createStatisticMessage(
        result: Map<LottoResult.Rank, Int>
    ): String {
        val lottoRanks = LottoResult.Rank.values()
        val matchMessage = lottoRanks.joinToString(separator = System.lineSeparator()) { rank ->
            val matchCount = result[rank]
            String.format(
                MATCH_MESSAGE_FORMAT.trimIndent(),
                rank.countOfMatch, rank.winningMoney, matchCount ?: 0
            )
        }
        return System.lineSeparator() + String.format(WINNING_STATISTICS_MESSAGE_FORMAT.trimIndent(), matchMessage)
    }

    private fun createEarningRateMessage(
        earningRate: Double
    ): String {
        return String.format(
            EARNING_RATE_MESSAGE_FORMAT,
            earningRate,
            if (earningRate > STANDARD_RATE) WIN else LOSE
        )
    }
}
