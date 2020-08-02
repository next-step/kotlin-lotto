package lotto

data class LottoNumber(
    private val value: Int
) {
    init {
        validateNumberRange(value)
    }

    private fun validateNumberRange(number: Int) {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "$number 는 로또 번호(1~45)가 아닙니다." }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
