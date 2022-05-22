package lotto.domain

import lotto.exception.InvalidLottoNumberException

class LottoNumber(val number: Int) {

    init {
        require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            throw InvalidLottoNumberException()
        }
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is LottoNumber -> other.number == this.number
            is Int -> other == this.number
            else -> false
        }
    }

    override fun hashCode(): Int {
        return number.hashCode()
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45

        fun all(): IntRange {
            return (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)
        }
    }
}
