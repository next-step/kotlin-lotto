package lotto.domain

import lotto.domain.model.*
import lotto.domain.model.vo.MatchCount
import lotto.domain.model.vo.Prize
import lotto.domain.model.vo.TicketCount
import lotto.domain.model.vo.WinningLottoNumberList


private const val WINNING_PRIZE_THREE_MATCH = 5_000
private const val WINNING_PRIZE_FOUR_MATCH = 50_000
private const val WINNING_PRIZE_FIVE_MATCH = 1_500_000
private const val WINNING_PRIZE_SIX_MATCH = 2_000_000_000

private const val WINNING_COUNT_THREE_MATCH = 3
private const val WINNING_COUNT_FOUR_MATCH = 4
private const val WINNING_COUNT_FIVE_MATCH = 5
private const val WINNING_COUNT_SIX_MATCH = 6

/**
 * 로또 추첨 기계
 * */
object LottoDrawMachine {

    enum class WinningType(val prize: Int, val matchCount: Int) {
        THREE_MATCH(WINNING_PRIZE_THREE_MATCH, WINNING_COUNT_THREE_MATCH),
        FOUR_MATCH(WINNING_PRIZE_FOUR_MATCH, WINNING_COUNT_FOUR_MATCH),
        FIVE_MATCH(WINNING_PRIZE_FIVE_MATCH, WINNING_COUNT_FIVE_MATCH),
        SIX_MATCH(WINNING_PRIZE_SIX_MATCH, WINNING_COUNT_SIX_MATCH)
    }

    /**
     * 로또 추첨
     * */
    fun runDrawLottoList(winningNumberText: String, lottoList: List<Lotto>): List<LottoMatchResult> {
        val winningLottoNumberList = WinningLottoNumberList.valueOf(winningNumberText)

        val lottoMatchResult = WinningType.values().map { winningType ->
            val prize = Prize.valueOf(winningType.prize)
            val matchCount = MatchCount.valueOf(winningType.matchCount)
            val ticketCount = TicketCount.valueOf(lottoList.filter { lotto -> lotto.getMatchCount(winningLottoNumberList) == winningType.matchCount }.size)

            LottoMatchResult(matchCount, prize, ticketCount)
        }

        return lottoMatchResult
    }
}
