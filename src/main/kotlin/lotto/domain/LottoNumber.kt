package lotto.domain

import java.lang.IllegalArgumentException

data class LottoNumber(val number: Int) {
    override fun toString() = "$number"

    companion object {
        const val INVALID_MESSAGE = "은/는 로또 번호가 아닙니다. 1 ~ 45사이의 값을 넣어주세요."
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        private val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER).map { it to LottoNumber(it) }.toMap()

        fun of(value: String): LottoNumber {
            return of(value.toInt())
        }

        fun of(number: Int): LottoNumber {
            return LOTTO_NUMBERS[number] ?: throw IllegalArgumentException("$number$INVALID_MESSAGE")
        }
    }
}
