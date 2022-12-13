package lotto.domain

import lotto.validator.LottoValidator.validateLottoSize

class Lotto private constructor(val elements: Set<LottoNumber>) {
    fun match(winningNumber: WinningNumber): MatchResult =
        matchCount(winningNumber).let {
            MatchResult.valueOf(it)
        }

    private fun matchCount(winningNumber: WinningNumber) =
        elements.intersect(winningNumber.lotto).size

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
