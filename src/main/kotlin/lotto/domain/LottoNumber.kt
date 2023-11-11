package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_LOWER_BOUND..LOTTO_UPPER_BOUND) {
            "로또 숫자는 ${LOTTO_LOWER_BOUND}부터 ${LOTTO_UPPER_BOUND}사이의 숫자여야 합니다."
        }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val LOTTO_LOWER_BOUND = 1
        const val LOTTO_UPPER_BOUND = 45
    }
}
