package lotto.domain

import java.lang.IllegalArgumentException


data class LottoNumber private constructor(
    val value: Int
) {

    init {
        require(value in MIN_NUMBER..MAX_NUMBER) { "$value 값은 1 ~ 45 까지만 허용됩니다." }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45


        private val cache: Map<Int, LottoNumber> = mapOf(
            *(MIN_NUMBER..MAX_NUMBER).map { Pair(it, LottoNumber(it)) }.toTypedArray()
        )

        fun of(number: Int): LottoNumber {
            return cache[number] ?: throw IllegalArgumentException(errorMessage(number))
        }

        private fun errorMessage(value: Int) = "$value 값은 1 ~ 45 까지만 허용됩니다."

    }
}
