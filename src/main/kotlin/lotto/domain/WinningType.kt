package lotto.domain

import lotto.domain.model.*
import lotto.domain.model.vo.MatchCount
import lotto.domain.model.vo.Prize
import lotto.domain.model.vo.WinningTicketCount
import lotto.domain.model.vo.WinningLottoNumbers

/**
 * 로또 추첨 기계
 * */
enum class WinningType(private val prize: Prize, private val matchCount: MatchCount) {
    THREE_MATCH(Prize.valueOf(5_000), MatchCount.valueOf(3)),
    FOUR_MATCH(Prize.valueOf(50_000), MatchCount.valueOf(4)),
    FIVE_MATCH(Prize.valueOf(1_500_000), MatchCount.valueOf(5)),
    FIVE_AND_BONUS_MATCH(Prize.valueOf(3_000_000), MatchCount.valueOf(5)),
    SIX_MATCH(Prize.valueOf(2_000_000_000), MatchCount.valueOf(6));

    companion object {
        /**
         * 로또 추첨
         * */
        fun runDrawLottos(winningNumberText: String, winningBonusNumberText: String,lottoList: List<Lotto>): List<LottoMatchResult> {
            val winningLottoNumbers = WinningLottoNumbers.of(winningNumberText, winningBonusNumberText)

            val lottoMatchResult = WinningType.values().map { winningType ->
                val winningTicketCount =
                    WinningTicketCount.valueOf(lottoList.filter { lotto -> match(lotto, winningType, winningLottoNumbers) }.size)

                LottoMatchResult(winningType.matchCount, winningType.prize, winningTicketCount, winningType == FIVE_AND_BONUS_MATCH)
            }

            return lottoMatchResult
        }

        private fun match(lotto: Lotto, winningType: WinningType, winningLottoNumbers: WinningLottoNumbers): Boolean {
            return when (winningType) {
                FIVE_AND_BONUS_MATCH -> {
                    lotto.getMatchCount(winningLottoNumbers) == winningType.matchCount.matchCount && lotto.getIsMatchNumber(winningLottoNumbers.winningBonusNumber)
                }
                FIVE_MATCH -> {
                    lotto.getMatchCount(winningLottoNumbers) == winningType.matchCount.matchCount && !lotto.getIsMatchNumber(winningLottoNumbers.winningBonusNumber)
                }
                else -> {
                    lotto.getMatchCount(winningLottoNumbers) == winningType.matchCount.matchCount
                }
            }
        }
    }
}
