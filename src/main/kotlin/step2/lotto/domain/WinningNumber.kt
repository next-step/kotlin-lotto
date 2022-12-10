package step2.lotto.domain

import step2.lotto.validator.LottoValidator.validateLottoSize
import step2.lotto.validator.NumberValidator.toInt

class WinningNumber private constructor(val element: Set<LottoNumber>) {
    companion object {
        fun of(inputNumbers: List<Int>): WinningNumber {
            val winningNumber = inputNumbers.map { LottoNumber.of(it) }.toSet()
            validateLottoSize(winningNumber)
            return WinningNumber(winningNumber)
        }

        fun ofStrings(inputStrings: List<String>): WinningNumber =
            inputStrings.map {
                toInt(it)
            }.run {
                of(this)
            }
    }
}
