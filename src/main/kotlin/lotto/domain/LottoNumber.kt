package lotto.domain

data class LottoNumber(val value: Int) {
    init {
        validateValue()
    }

    private fun validateValue() {
        if (value < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < value) {
            throw InvalidLottoNumberException(value)
        }
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
