package lotto.entity

import lotto.util.LOTTO_PRICE
import lotto.util.MAX_LOTTO_NUMBER
import lotto.util.MIN_LOTTO_NUMBER
import kotlin.random.Random

class Lotto private constructor(
    val numbers: Set<LottoNumber>
) {
    companion object {
        private const val NUMBER_OF_LOTTO_NUMBER = 6

        fun ticketing(money: String): List<Lotto> = (1..(money.toInt() / LOTTO_PRICE)).map { of() }

        private fun of(): Lotto =
            Lotto(numbers = generateSequence { Random.nextInt(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1) }
                .distinct().take(NUMBER_OF_LOTTO_NUMBER)
                .map { LottoNumber(it) }
                .sortedBy { it.value }
                .toSet())
    }
}
