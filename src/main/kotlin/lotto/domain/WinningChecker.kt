package lotto.domain

import calculator.Tokenizer

object WinningChecker {

    fun win(winningNumberStrings: String, lottoNumbers: List<Int>, bonusNumber: Int): Winner {
        val winningNumbers: List<Int> = Tokenizer.tokenize(winningNumberStrings).map {
            it.toInt()
        }

        val matchNumberCount = LottoMatcher.countMatchNumber(winningNumbers, lottoNumbers)
        return LottoMatcher.matchingWinner(matchNumberCount)
    }
}
