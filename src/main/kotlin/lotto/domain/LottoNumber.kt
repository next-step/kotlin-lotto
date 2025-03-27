package lotto.domain

class LottoNumber(
    private val value: Int,
) {
    init {
        require(value in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
            "value must be between 1 and 45 (inclusive)"
        }
    }

    companion object {
        private const val MINIMUM_LOTTO_NUMBER = 1
        private const val MAXIMUM_LOTTO_NUMBER = 45
    }
}
