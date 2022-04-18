package lotto.domain

data class LottoNumber(private val number: Int) {

    init {
        require(isValid())
    }

    private fun isValid(): Boolean = number in NUMBER_RANGE

    companion object {
        private const val NUMBER_RANGE_START = 1
        private const val NUMBER_RANGE_END = 45
        val NUMBER_RANGE = NUMBER_RANGE_START..NUMBER_RANGE_END
    }
}
