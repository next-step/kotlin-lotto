package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.domain.Rank
import java.math.BigDecimal

object ResultView {
    private const val BUY_COUNT_SUFFIX = "개를 구매했습니다."
    private const val WINNING_STATISTICS = "당첨 통계"
    private const val WINNING_SEPARATOR = "---------"
    private const val COUNT_SUFFIX = "개"
    private const val SEPARATOR = "- "
    private const val TOTAL_RATE_PREFIX = "총 수익률은 "
    private const val TOTAL_RATE_SUFFIX = "입니다."
    private const val ACCORDANCE_SUFFIX = "개 일치"
    private const val BONUS_SUFFIX = ", 보너스 볼 일치"

    fun printLottos(lottoTicket: LottoTicket) {
        println("${lottoTicket.lottos.size}$BUY_COUNT_SUFFIX")
        printJoinToString(lottoTicket.lottos)
    }

    fun printResult(result: LottoResult) {
        println(WINNING_STATISTICS)
        println(WINNING_SEPARATOR)
        Rank.asList().forEach {
            printRankResult(it, result)
        }
    }

    private fun printRankResult(rank: Rank, result: LottoResult) {
        println(
            if (rank.matchBonus) "${rank.countOfMatch}$ACCORDANCE_SUFFIX$BONUS_SUFFIX(${rank.winningMoney})$SEPARATOR${result.countByRank(rank)}$COUNT_SUFFIX"
            else "${rank.countOfMatch}$ACCORDANCE_SUFFIX(${rank.winningMoney})$SEPARATOR${result.countByRank(rank)}$COUNT_SUFFIX"
        )
    }

    fun printTotalRate(totalRate: BigDecimal) {
        println("$TOTAL_RATE_PREFIX${totalRate}$TOTAL_RATE_SUFFIX")
    }

    private fun printJoinToString(lottos: List<Any>) {
        println(lottos.joinToString(""))
    }
}
