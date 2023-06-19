package lotto.controller

import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Prize

data class WinningNumbers(val lottoNumbers: LottoNumbers, val bonusNumber: Int) {

    fun calculateMatchResult(lottos: Lottos): MatchResult {
        val matches = lottos.lottoList.asSequence()
            .map { Pair(countMatches(it), isBonusMatch(it)) }
            .map { classifyPrize(it.first, it.second) }
            .groupingBy { it }
            .eachCount()
        return MatchResult(matches)
    }

    private fun countMatches(other: LottoNumbers): Int {
        return lottoNumbers.countMatches(other)
    }

    private fun isBonusMatch(other: LottoNumbers): Boolean {
        return other.lottoNumbers.contains(bonusNumber)
    }

    private fun classifyPrize(matchCount: Int, hasBonus: Boolean): Prize {
        if (matchCount == 5 && hasBonus) {
            return Prize.SECOND
        }
        return Prize.prizeForMatchCount(matchCount)
    }

    companion object {
        fun of(lottoNumbers: LottoNumbers, bonusNumber: Int): WinningNumbers {
            return WinningNumbers(lottoNumbers, bonusNumber)
        }
    }
}
