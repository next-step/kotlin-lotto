package lotto.domain

data class LottoNumber(
    val number: Long
) {
    init {
        require(number in LOTTO_NUMBER_START_BOUND..LOTTO_NUMBER_END_BOUND) {
            "로또 숫자는 1이상 43이하의 숫자여야 해요"
        }
    }

    companion object {
        const val LOTTO_NUMBER_START_BOUND = 1L
        const val LOTTO_NUMBER_END_BOUND = 43L

        fun of(number: String): LottoNumber {
            return LottoNumber(number.toLong())
        }
    }
}
