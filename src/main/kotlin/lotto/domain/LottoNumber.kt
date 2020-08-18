package lotto.domain

import lotto.domain.LottoNumber.Companion.MAXIMUM_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_NUMBER

class LottoNumber private constructor(private val value: Int) {
    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        private val NUMBERS: Map<Int, LottoNumber> = (MINIMUM_NUMBER..MAXIMUM_NUMBER).associateWith { LottoNumber(it) }

        fun get(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException()
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}

fun generateNumbers(): Set<LottoNumber> {
    return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
        .take(6)
        .sorted()
        .map { LottoNumber.get(it) }
        .toSet()
}
