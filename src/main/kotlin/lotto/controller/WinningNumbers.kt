package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Prize

data class WinningNumbers(val lottoNumbers: LottoNumbers) {

    fun calculateMatchResult(lottos: Lottos): MatchResult {
        val matches = lottos.lottoList.asSequence()
            .map { countMatches(it) }
            .filter { it >= 3 }
            .mapNotNull { Prize.prizeForMatchCount(it) }
            .groupingBy { it }
            .eachCount()
        return MatchResult(matches)
    }

    fun countMatches(other: LottoNumbers): Int {
        return lottoNumbers.countMatches(other.lottoNumbers)
    }

    companion object {
        fun of(lottoNumbers: LottoNumbers): WinningNumbers {
            return WinningNumbers(lottoNumbers)
        }
    }
}
