package lotto.controller

import lotto.domain.Lottos

object LottoMatcher {

    private const val MINIMUM_MATCH_COUNT = 3

    fun matchingLotto(lottos: Lottos, winningNumbers: WinningNumbers): MatchResult {
        val matches = mutableMapOf<Int, Int>()

        lottos.lottoList.forEach { lottoNumbers ->
            val matchCount = winningNumbers.countMatches(lottoNumbers)
            incrementMatchCount(matches, matchCount)
        }

        return MatchResult(matches)
    }

    private fun incrementMatchCount(matches: MutableMap<Int, Int>, matchCount: Int) {
        if (matchCount >= MINIMUM_MATCH_COUNT) {
            matches[matchCount] = matches.getOrDefault(matchCount, 0) + 1
        }
    }
}
