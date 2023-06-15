package lotto.domain

data class LottoNumbers(
    val numbers: List<Int>,
) {
    init {
        require(numbers.size == LENGTH)
    }

    companion object {
        const val LENGTH = 6
        private const val MINIMUM = 1
        private const val MAX = 45

        fun generate(): LottoNumbers {
            return LottoNumbers(generateLottoNumbers())
        }

        private fun generateLottoNumbers(): List<Int> = (MINIMUM..MAX).shuffled()
            .take(LENGTH)
            .sorted()
    }
}
