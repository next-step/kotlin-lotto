package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Lottos
import lotto.domain.Prize

data class WinningNumbers(val lottoNumbers: LottoNumbers, val bonusNumber: LottoNumber) {

    fun calculateMatchResult(lottos: Lottos): MatchResult {
        val matches = lottos.lottoList.asSequence()
            .map { Prize.prizeFor(countMatches(it), isBonusMatch(it)) }
            .groupingBy { it }
            .eachCount()
        return MatchResult(matches)
    }

    private fun countMatches(other: LottoNumbers): Int {
        return lottoNumbers.countMatches(other)
    }

    private fun isBonusMatch(other: LottoNumbers): Boolean {
        return other.lottoNumbers.any { it.value == bonusNumber.value }
    }

    companion object {
        fun of(lottoNumbers: LottoNumbers, bonusNumber: Int): WinningNumbers {
            return WinningNumbers(lottoNumbers, LottoNumber(bonusNumber))
        }
    }
}
