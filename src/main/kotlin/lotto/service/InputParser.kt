package lotto.service

import lotto.domain.LottoNumber

object InputParser {

    fun parsePurchaseAmount(input: String): Int {
        return input.toInt()
    }

    fun parseWinningNumbers(input: String): List<LottoNumber> {
        val numbers = input.split(", ")

        return numbers.map { it.toInt() }.map(LottoNumber::of)
    }
}
