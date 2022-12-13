package lotto.domain

import lotto.validator.LottoValidator.validateLottoSize

class Lotto private constructor(private val elements: Set<LottoNumber>) {
    override fun toString(): String {
        return "$elements"
    }

    fun match(winningNumber: WinningNumber): MatchResult =
        matchCount(winningNumber).let {
            MatchResult.valueOf(it)
        }

    private fun matchCount(winningNumber: WinningNumber) =
        elements.intersect(winningNumber.element).size

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
