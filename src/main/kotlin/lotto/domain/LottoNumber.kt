package lotto.domain

class LottoNumber private constructor(val number: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int = number.compareTo(other.number)

    companion object {
        private const val INVALID_NUMBER_RANGE_MESSAGE = "유효한 로또 숫자는 1 ~ 45 사이입니다. Input:"

        const val MIN_VALUE: Int = 1
        const val MAX_VALUE: Int = 45
        private val store = (MIN_VALUE..MAX_VALUE).associateWith { LottoNumber(it) }

        fun valueOf(number: Int): LottoNumber =
            store[number] ?: throw IllegalArgumentException("$INVALID_NUMBER_RANGE_MESSAGE $number")
    }
}
