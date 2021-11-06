package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in VALID_NUMBER_RANGE) { INVALID_NUMBER_ERROR_MSG }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private val VALID_NUMBER_RANGE = (1..45)
        private const val INVALID_NUMBER_ERROR_MSG = "유효하지 않은 번호입니다."
    }
}
