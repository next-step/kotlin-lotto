package step2.lotto.domain

import step2.lotto.domain.LottoValidator.validateLottoSize

class Lotto private constructor(private val elements: Set<LottoNumber>) {
    fun match(winningNumber: WinningNumber): MatchResult =
        matchCount(winningNumber).let {
            MatchResult.valueOf(it)
        }

    private fun matchCount(winningNumber: WinningNumber) =
        elements.intersect(winningNumber.element).size

    companion object {
        fun of(inputNumbers: Set<Int>): Lotto {
            val lottoNumbers = inputNumbers.map {
                LottoNumber.of(it)
            }.toSet()
            validateLottoSize(lottoNumbers)
            return Lotto(lottoNumbers)
        }
    }
}
