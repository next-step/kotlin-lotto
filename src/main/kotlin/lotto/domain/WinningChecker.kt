package lotto.domain

import calculator.Tokenizer

object WinningChecker {

    fun win(winningNumberStrings: String, lottoNumbers: List<Int>): Winner {
        val winningNumbers: List<Int> = Tokenizer.tokenize(winningNumberStrings).map {
            it.toInt()
        }

        val matchingCount = LottoMatcher.countMatchNumber(winningNumbers, lottoNumbers)
        return LottoRewardCalculator.calculate(matchingCount)
    }
}