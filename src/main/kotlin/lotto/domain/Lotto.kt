package lotto.domain

import lotto.validator.LottoValidator.validateLottoSize
import kotlin.streams.toList

class Lotto private constructor(private val elements: Set<LottoNumber>) {
    fun sortedLotto(): List<LottoNumber> = elements.stream().sorted().toList()

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
            val lottoNumbers = inputNumbers.map {
                LottoNumber.of(it)
            }.toSet()
            validateLottoSize(lottoNumbers)
            return Lotto(lottoNumbers)
        }
    }
}
