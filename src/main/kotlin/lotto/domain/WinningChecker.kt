package lotto.domain

import calculator.Tokenizer

object WinningChecker {

    fun win(winningNumberStrings: String, lottoNumbers: List<Int>, bonusNumber: Int = 0): Winner {
        val winningNumbers: List<Int> = Tokenizer.tokenize(winningNumberStrings).map {
            it.toInt()
        }

        val matchNumberCount: Int = LottoMatcher.countMatchNumber(winningNumbers, lottoNumbers)
        val bonus: Boolean = LottoMatcher.matchBonus(matchNumberCount, lottoNumbers, bonusNumber)
        return LottoMatcher.matchingWinner(matchNumberCount, bonus)
    }
}
