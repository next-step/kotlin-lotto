package lotto.controller

import lotto.domain.Lotto

class LottoMatcher {

    companion object {
        private const val MINIMUM_MATCH_COUNT = 3

        fun matchingLotto(lotto: Lotto, winningNumbers: WinningNumbers): Map<Int, Int> {
            val matches = mutableMapOf<Int, Int>()
            lotto.lottoList.forEach { lottoNumbers ->
                var matchCount = 0
                lottoNumbers.lottoNumbers.forEach { number ->
                    if (winningNumbers.numbers.contains(number)) {
                        matchCount++
                    }
                }
                if (matchCount >= MINIMUM_MATCH_COUNT) {
                    matches[matchCount] = matches.getOrDefault(matchCount, 0) + 1
                }
            }
            return matches
        }
    }
}
