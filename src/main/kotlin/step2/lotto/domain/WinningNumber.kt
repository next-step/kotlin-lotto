package step2.lotto.domain

import step2.lotto.domain.LottoValidator.validateLottoSize

class WinningNumber private constructor(val element: Set<LottoNumber>) {
    companion object {
        fun of(inputNumbers: List<Int>): WinningNumber {
            val winningNumber = inputNumbers.map { LottoNumber.of(it) }.toSet()
            validateLottoSize(winningNumber)
            return WinningNumber(winningNumber)
        }
    }
}
