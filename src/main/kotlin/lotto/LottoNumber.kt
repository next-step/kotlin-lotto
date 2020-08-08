package lotto

import java.lang.IllegalArgumentException

const val LOTTO_MIN_NUMBER = 1
const val LOTTO_MAX_NUMBER = 45

data class LottoNumber private constructor(private val number: Int) {
    companion object {
        private val LOTTO_NUMBERS = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).map { it to LottoNumber(it) }.toMap()

        fun of(value: String): LottoNumber {
            return of(value.toInt())
        }

        fun of(number: Int): LottoNumber {
            return LOTTO_NUMBERS[number] ?: throw IllegalArgumentException("${number}는 로또 번호가 아닙니다.")
        }
    }
}
