package lotto.domain

class LottoNumber(val number: Int) {
    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        val CACHED_NUMBER = (MIN_NUMBER..MAX_NUMBER).map(::LottoNumber)

        fun valueOf(num: Int): LottoNumber {
            require(num in MIN_NUMBER..MAX_NUMBER) {
                "Invalid LottoNumber: $MIN_NUMBER and $MAX_NUMBER 사이의 값이여야 합니다."
            }
            return CACHED_NUMBER[num - 1]
        }
    }

    override fun toString(): String {
        return number.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is LottoNumber) {
            return false
        }
        return this.number == other.number
    }

    override fun hashCode(): Int {
        return number.hashCode()
    }
}
