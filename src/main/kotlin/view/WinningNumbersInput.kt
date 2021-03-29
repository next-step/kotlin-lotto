package view

import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers
import domain.winning.WinningNumbers

data class WinningNumbersInput(val numbers: List<Int>, val bonus: Int) {
    constructor(numbers: String, bonus: Int) : this(parseNumbers(numbers), bonus)

    fun toWinningNumbers(): WinningNumbers {
        return WinningNumbers(
            LottoNumbers.fromList(numbers.map { LottoNumber.parse(it) }),
            bonus = LottoNumber.parse(bonus)
        )
    }

    companion object {
        private fun parseNumbers(string: String): List<Int> {
            return string.split("\\s*,\\s*".toRegex())
                .map { it.toInt() }
        }
    }
}
