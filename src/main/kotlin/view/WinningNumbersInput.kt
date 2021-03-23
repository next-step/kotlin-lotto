package view

import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers

data class WinningNumbersInput(val numbers: List<Int>) {
    constructor(numbers: String) : this(parseNumbers(numbers))

    fun toLottoNumbers(): LottoNumbers {
        return LottoNumbers(numbers.map { LottoNumber.parse(it) })
    }

    companion object {
        private fun parseNumbers(string: String): List<Int> {
            return string.split("\\s*,\\s*".toRegex())
                .map { it.toInt() }
        }
    }
}
