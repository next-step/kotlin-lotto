package lotto.domain

import java.lang.IllegalArgumentException

fun Iterable<Int>.toLottoNumberSet(): Set<LottoNumber> {
    return this.map(LottoNumber.Companion::from).toSet()
}

class LottoNumber private constructor(private val value: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }

    override fun toString(): String {
        return "$value"
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private val NUMBER_CACHE: Map<Int, LottoNumber> = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).associateWith(::LottoNumber)
        val LOTTO_NUMBERS = NUMBER_CACHE.values

        fun from(value: Int): LottoNumber {
            return NUMBER_CACHE[value] ?: throw IllegalArgumentException(
                "lotto number must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER"
            )
        }
    }
}
