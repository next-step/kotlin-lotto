package lotto.domain

import lotto.domain.model.*
import lotto.domain.model.vo.MatchCount
import lotto.domain.model.vo.Prize
import lotto.domain.model.vo.WinningTicketCount
import lotto.domain.model.vo.WinningLottoNumberList

/**
 * 로또 추첨 기계
 * */
object LottoDrawMachine {

    enum class WinningType(val prize: Int, val matchCount: Int) {
        THREE_MATCH(5_000, 3),
        FOUR_MATCH(50_000, 4),
        FIVE_MATCH(1_500_000, 5),
        SIX_MATCH(2_000_000_000, 6)
    }

    /**
     * 로또 추첨
     * */
    fun runDrawLottoList(winningNumberText: String, lottoList: List<Lotto>): List<LottoMatchResult> {
        val winningLottoNumberList = WinningLottoNumberList.valueOf(winningNumberText)

        val lottoMatchResult = WinningType.values().map { winningType ->
            val prize = Prize.valueOf(winningType.prize)
            val matchCount = MatchCount.valueOf(winningType.matchCount)
            val winningTicketCount = WinningTicketCount.valueOf(lottoList.filter { lotto -> lotto.getMatchCount(winningLottoNumberList) == winningType.matchCount }.size)

            LottoMatchResult(matchCount, prize, winningTicketCount)
        }

        return lottoMatchResult
    }
}
