package lotto.domain

class LottoNumberGenerator {
    fun generateRandomNumber(): List<Int> = NUMBER_RANGE.shuffled().take(NUMBER_SIZE).sorted()

    companion object {
        private const val NUMBER_SIZE = 6
        private const val NUMBER_START = 1
        private const val NUMBER_END = 45
        private val NUMBER_RANGE = NUMBER_START..NUMBER_END
    }
}
