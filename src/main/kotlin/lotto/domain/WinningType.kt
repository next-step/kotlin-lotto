package lotto.domain

import lotto.domain.model.BonusMatch
import lotto.domain.model.Lotto
import lotto.domain.model.LottoMatchResult
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers
import lotto.domain.model.MatchCount
import lotto.domain.model.Prize
import lotto.domain.model.WinningLottoNumbers
import lotto.domain.model.WinningTicketCount

/**
 * 로또 추첨 기계
 * */
enum class WinningType(
    private val prize: Prize,
    private val matchCount: MatchCount,
    private val bonusMatch: BonusMatch
) {
    THREE_MATCH(Prize.valueOf(5_000), MatchCount.valueOf(3), BonusMatch.from(false)),
    FOUR_MATCH(Prize.valueOf(50_000), MatchCount.valueOf(4), BonusMatch.from(false)),
    FIVE_MATCH(Prize.valueOf(1_500_000), MatchCount.valueOf(5), BonusMatch.from(false)),
    FIVE_AND_BONUS_MATCH(Prize.valueOf(3_000_000), MatchCount.valueOf(5), BonusMatch.from(true)),
    SIX_MATCH(Prize.valueOf(2_000_000_000), MatchCount.valueOf(6), BonusMatch.from(false));

    companion object {
        /**
         * 로또 추첨
         * */
        fun runDrawLottos(
            winningNumbers: LottoNumbers,
            bonusNumber: LottoNumber,
            lottoList: List<Lotto>
        ): List<LottoMatchResult> {
            val winningLottoNumbers = WinningLottoNumbers.of(winningNumbers, bonusNumber)

            val lottoMatchResult = WinningType.values().map { winningType ->
                val winningTicketCount =
                    WinningTicketCount.valueOf(
                        lottoList.filter { lotto ->
                            match(
                                lotto,
                                winningType,
                                winningLottoNumbers
                            )
                        }.size
                    )

                LottoMatchResult(winningType.matchCount, winningType.prize, winningTicketCount, winningType.bonusMatch)
            }

            return lottoMatchResult
        }

        private fun match(lotto: Lotto, winningType: WinningType, winningLottoNumbers: WinningLottoNumbers): Boolean {
            val isMatch = lotto.getMatchCount(winningLottoNumbers) == winningType.matchCount.value
            return isMatch && matchBonus(lotto, winningType, winningLottoNumbers)
        }

        private fun matchBonus(
            lotto: Lotto,
            winningType: WinningType,
            winningLottoNumbers: WinningLottoNumbers
        ): Boolean {
            return winningType.bonusMatch.value == lotto.matchNumber(winningLottoNumbers.winningBonusNumber)
        }
    }
}
