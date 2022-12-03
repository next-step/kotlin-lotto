package lotto.domain

import lotto.domain.model.Rank
import lotto.domain.model.WinningNumbers

object WinningChecker {

    fun win(winningNumbers: WinningNumbers, lottoNumbers: List<Int>, bonusNumber: Int = 0): Rank {
        val matchCount: Int = LottoMatcher.countMatchNumber(winningNumbers, lottoNumbers)
        val matchBonus: Boolean = LottoMatcher.matchBonus(matchCount, lottoNumbers, bonusNumber)
        return LottoMatcher.matchingWinner(matchCount, matchBonus)
    }
}
