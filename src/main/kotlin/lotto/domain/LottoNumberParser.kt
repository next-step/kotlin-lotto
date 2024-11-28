package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBERS_COUNT
import lotto.domain.LottoNumber.Companion.LOTTO_MAX_NUMBER
import lotto.domain.LottoNumber.Companion.LOTTO_MIN_NUMBER

object LottoNumberParser {
    fun parse(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toIntOrNull() }
        require(numbers.size == LOTTO_NUMBERS_COUNT) {
            "A single lotto ticket should have $LOTTO_NUMBERS_COUNT numbers"
        }
        require(numbers.all { it != null && it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            "Lotto numbers should be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER"
        }
        return numbers.filterNotNull()
    }
}
