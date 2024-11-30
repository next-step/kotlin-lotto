package lotto.core

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { ERROR_INVALID_NUMBER_SCOPE }
    }

    companion object {
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
        private const val ERROR_INVALID_NUMBER_SCOPE = "로또 번호의 범위가 잘못되었습니다."
    }

    override fun toString(): String {
        return number.toString()
    }
}
