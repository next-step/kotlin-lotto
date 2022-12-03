package lotto.domain

import calculator.Tokenizer
import lotto.domain.model.Rank

object WinningChecker {

    fun win(winningNumberStrings: String, lottoNumbers: List<Int>, bonusNumber: Int = 0): Rank {
        val winningNumbers: List<Int> = Tokenizer.tokenize(winningNumberStrings).map {
            it.toInt()
        }

        val matchCount: Int = LottoMatcher.countMatchNumber(winningNumbers, lottoNumbers)
        val matchBonus: Boolean = LottoMatcher.matchBonus(matchCount, lottoNumbers, bonusNumber)
        return LottoMatcher.matchingWinner(matchCount, matchBonus)
    }
}
