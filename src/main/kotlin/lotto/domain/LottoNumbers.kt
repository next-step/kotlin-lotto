package lotto.domain

data class LottoNumbers(
    val numbers: List<Int>,
) {
    init {
        require(numbers.size == LENGTH)
        require(numbers.all(::inValidRange))
        require(hasUniqueNumbers())
    }

    private fun inValidRange(number: Int): Boolean = number in MINIMUM..MAXIMUM

    private fun hasUniqueNumbers(): Boolean {
        return numbers.groupingBy { it }
            .eachCount()
            .all {
                it.value == 1
            }
    }

    companion object {
        const val LENGTH = 6
        private const val MINIMUM = 1
        private const val MAXIMUM = 45

        fun generate(): LottoNumbers {
            return LottoNumbers(generateLottoNumbers())
        }

        private fun generateLottoNumbers(): List<Int> = (MINIMUM..MAXIMUM).shuffled()
            .take(LENGTH)
            .sorted()
    }
}
