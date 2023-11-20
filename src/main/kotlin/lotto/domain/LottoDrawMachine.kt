package lotto.domain

import lotto.domain.model.*
import lotto.domain.model.vo.MatchCount
import lotto.domain.model.vo.Prize
import lotto.domain.model.vo.WinningTicketCount
import lotto.domain.model.vo.WinningLottoNumbers

/**
 * 로또 추첨 기계
 * */
enum class LottoDrawMachine(private val prize: Prize, private val matchCount: MatchCount) {
    THREE_MATCH(Prize.valueOf(5_000), MatchCount.valueOf(3)),
    FOUR_MATCH(Prize.valueOf(50_000), MatchCount.valueOf(4)),
    FIVE_MATCH(Prize.valueOf(1_500_000), MatchCount.valueOf(5)),
    SIX_MATCH(Prize.valueOf(2_000_000_000), MatchCount.valueOf(6));

    companion object {
        /**
         * 로또 추첨
         * */
        fun runDrawLottos(winningNumberText: String, lottoList: List<Lotto>): List<LottoMatchResult> {
            val winningLottoNumbers = WinningLottoNumbers.valueOf(winningNumberText)

            val lottoMatchResult = LottoDrawMachine.values().map { winningType ->
                val prize = winningType.prize
                val matchCount = winningType.matchCount
                val winningTicketCount =
                    WinningTicketCount.valueOf(lottoList.filter { lotto -> lotto.getMatchCount(winningLottoNumbers) == winningType.matchCount.matchCount }.size)

                LottoMatchResult(matchCount, prize, winningTicketCount)
            }

            return lottoMatchResult
        }
    }
}
