package lotto.domain

class LottoNumber(val value: Int) {
    init {
        validateRangeOfNumber(value)
    }

    private fun validateRangeOfNumber(number: Int) {
        require(number in LOTTO_NUMBER_RANGE) { "로또 번호는 ${LOTTO_NUMBER_RANGE}이어야 합니다." }
    }

    override fun equals(other: Any?): Boolean {
        return this.value == (other as LottoNumber).value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = (1..45)

        fun random(): LottoNumber {
            return LottoNumber(LOTTO_NUMBER_RANGE.random())
        }
    }
}
