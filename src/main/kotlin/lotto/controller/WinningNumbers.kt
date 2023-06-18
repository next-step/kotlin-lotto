package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos

data class WinningNumbers(val lottoNumbers: LottoNumbers) {

    fun countMatches(other: LottoNumbers): Int {
        return lottoNumbers.countMatches(other.lottoNumbers)
    }

    fun calculateMatchResult(lottos: Lottos): MatchResult {
        val matches = mutableMapOf<Int, Int>()
        lottos.lottoList.forEach { lottoNumbers ->
            val matchCount = countMatches(lottoNumbers)
            incrementMatchCount(matches, matchCount)
        }
        return MatchResult(matches)
    }

    private fun incrementMatchCount(matches: MutableMap<Int, Int>, matchCount: Int) {
        val minimumMatchCount = 3
        if (matchCount >= minimumMatchCount) {
            matches[matchCount] = matches.getOrDefault(matchCount, 0) + 1
        }
    }

    companion object {
        fun of(lottoNumbers: LottoNumbers): WinningNumbers {
            return WinningNumbers(lottoNumbers)
        }
    }
}
