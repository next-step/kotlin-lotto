package step2.lotto.domain

import step2.lotto.domain.LottoValidator.validateLottoSize

class Lotto private constructor(private val elements: Set<LottoNumber>) {
    fun match(winningNumber: WinningNumber): Int =
        elements.intersect(winningNumber.element).size

    companion object {
        fun of(inputNumbers: List<Int>): Lotto {
            val lottoNumbers = inputNumbers.map {
                LottoNumber.of(it)
            }.toSet()
            validateLottoSize(lottoNumbers)
            return Lotto(lottoNumbers)
        }
    }
}
