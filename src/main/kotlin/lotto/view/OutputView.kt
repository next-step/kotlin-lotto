package lotto.view

import lotto.domain.Charge
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoMatchResult
import lotto.domain.LottoRank

object OutputView {

    private const val BUYING_MESSAGE_FORMAT = "%s개를 구매했습니다. 거스름돈은 %d원입니다."
    private const val LOTTO_FORMAT = "[%s]"
    private const val WINNING_STATISTICS_MESSAGE_FORMAT = """
        당첨 통계
        ---------
        %s
    """
    private const val MATCH_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개"
    private const val BONUS_BALL_MATCH_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개"
    private const val STANDARD_RATE = 1
    private const val EARNING_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.(기준이 ${STANDARD_RATE}이기 때문에 결과적으로 %s(이)라는 의미임)"
    private const val WIN = "이득"
    private const val LOSE = "손해"

    fun printLottos(lottoMachine: LottoMachine, change: Charge) {
        println(String.format(BUYING_MESSAGE_FORMAT, lottoMachine.lottoCount.value, change.value))
        lottoMachine.lottos.forEach { printLottoNumbers(it) }
    }

    private fun printLottoNumbers(it: Lotto) {
        val lottoNumbers = it.numbers.sortedValues
            .map { number -> number.value }
            .joinToString(", ")
        println(String.format(LOTTO_FORMAT, lottoNumbers))
    }

    fun printLottoResult(lottoMatchResult: LottoMatchResult) {
        val statisticsMessage = createStatisticMessage(lottoMatchResult.result)
        val earningRateMessage = createEarningRateMessage(lottoMatchResult.earningRate)
        println(statisticsMessage)
        println(earningRateMessage)
    }

    private fun createStatisticMessage(
        result: Map<LottoRank, Int>,
    ): String {
        val lottoRanks = LottoRank.values()
            .filterNot { it.isMiss() }
            .sortedBy { it.winningMatchCount }
        val statisticsMessage =
            lottoRanks.joinToString(separator = System.lineSeparator()) { rank -> createMatchMessage(result, rank) }
        return System.lineSeparator() + String.format(WINNING_STATISTICS_MESSAGE_FORMAT.trimIndent(), statisticsMessage)
    }

    private fun createMatchMessage(
        result: Map<LottoRank, Int>,
        rank: LottoRank,
    ): String {
        val matchCount = result[rank] ?: 0
        return if (rank.isSecond()) {
            createBonusMatchMessage(rank, matchCount)
        } else {
            createMatchMessage(rank, matchCount)
        }
    }

    private fun createMatchMessage(rank: LottoRank, matchCount: Int) = String.format(
        MATCH_MESSAGE_FORMAT.trimIndent(),
        rank.winningMatchCount,
        rank.winningMoney,
        matchCount
    )

    private fun createBonusMatchMessage(rank: LottoRank, matchCount: Int) = String.format(
        BONUS_BALL_MATCH_MESSAGE_FORMAT.trimIndent(),
        rank.winningMatchCount,
        rank.winningMoney,
        matchCount
    )

    private fun createEarningRateMessage(
        earningRate: Double,
    ): String {
        return String.format(
            EARNING_RATE_MESSAGE_FORMAT,
            earningRate,
            if (earningRate > STANDARD_RATE) WIN else LOSE
        )
    }
}
