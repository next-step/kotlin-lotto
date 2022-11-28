package lotto.domain

import calculator.Tokenizer

object WinningChecker {

    fun win(winningNumberStrings: String, lottoNumbers: List<Int>): WinningResult {
        val winningNumbers: List<Int> = Tokenizer.tokenize(winningNumberStrings).map {
            it.toInt()
        }

        val matchingCount = LottoMatcher.countMatchNumber(winningNumbers, lottoNumbers)
        val reward = LottoRewardCalculator.calculate(matchingCount)

        return WinningResult(matchingCount, reward)
    }
}