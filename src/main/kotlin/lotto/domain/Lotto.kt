package lotto.domain

import lotto.validator.LottoValidator.validateLottoSize

class Lotto private constructor(val elements: Set<LottoNumber>) {
    fun match(winningNumber: WinningNumber): MatchResult {
        val matchCount = matchCount(winningNumber)
        val containsBonusNumber = contain(winningNumber.bonusNumber)
        return MatchResult.valueOf(matchCount, containsBonusNumber)
    }

    private fun matchCount(winningNumber: WinningNumber): Int =
        elements.intersect(winningNumber.winningLotto).size

    fun contain(bonusNumber: LottoNumber): Boolean = elements.contains(bonusNumber)

    companion object {
        fun of(inputNumbers: Set<Int>): Lotto {
            val lottoNumbers = inputNumbers.sorted()
                .map { LottoNumber.of(it) }
                .toSet()

            validateLottoSize(lottoNumbers)
            return Lotto(lottoNumbers)
        }
    }
}
