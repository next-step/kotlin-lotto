package lotto.domain

data class Lotto(val numbers: List<Int>) : List<Int> by numbers {

    init {
        require(isValidNumbers())
    }

    fun match(target: Lotto) = intersect(target).size

    private fun isValidNumbers(): Boolean {
        numbers.distinct().also {
            return it.size == NUMBER_SIZE && it.filterNot { number -> number in NUMBER_RANGE }.isEmpty()
        }
    }

    companion object {
        private const val NUMBER_SIZE = 6
        private const val NUMBER_RANGE_START = 1
        private const val NUMBER_RANGE_END = 45
        private val NUMBER_RANGE = NUMBER_RANGE_START..NUMBER_RANGE_END

        private fun generateRandom(): List<Int> {
            return NUMBER_RANGE.shuffled().take(NUMBER_SIZE).sorted()
        }

        fun buyRandom(): Lotto {
            return Lotto(generateRandom())
        }
    }
}
