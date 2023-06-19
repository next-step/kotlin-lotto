package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Prize

data class WinningNumbers(val lottoNumbers: LottoNumbers) {

    fun calculateMatchResult(lottos: Lottos): MatchResult {
        val matches = mutableMapOf<Prize, Int>()
        lottos.lottoList.forEach { lottoNumbers ->
            val matchCount = countMatches(lottoNumbers)
            incrementMatchCount(matches, matchCount)
        }
        return MatchResult(matches)
    }

    fun countMatches(other: LottoNumbers): Int {
        return lottoNumbers.countMatches(other.lottoNumbers)
    }

    private fun incrementMatchCount(matches: MutableMap<Prize, Int>, matchCount: Int) {
        val minimumMatchCount = 3
        if (matchCount >= minimumMatchCount) {
            val prize = Prize.prizeForMatchCount(matchCount)
            if (prize != null) {
                matches[prize] = matches.getOrDefault(prize, 0) + 1
            }
        }
    }
    companion object {
        fun of(lottoNumbers: LottoNumbers): WinningNumbers {
            return WinningNumbers(lottoNumbers)
        }
    }
}
