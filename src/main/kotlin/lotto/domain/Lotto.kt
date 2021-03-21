package lotto.domain

data class Lotto(val numbers: List<Int>) {

    init {
        require(validateNumbers())
    }

    private fun validateNumbers(): Boolean {
        numbers.distinct().also {
            return it.size == NUMBER_SIZE && it.filterNot { number -> number in NUMBER_RANGE }.isEmpty()
        }
    }

    companion object {
        private const val PRICE = 1000
        private const val NUMBER_SIZE = 6
        private const val NUMBER_RANGE_START = 1
        private const val NUMBER_RANGE_END = 45
        private val NUMBER_RANGE = NUMBER_RANGE_START..NUMBER_RANGE_END

        private fun generateRandom(): List<Int> {
            return NUMBER_RANGE.shuffled().take(NUMBER_SIZE).sorted()
        }

        fun buyRandom(price: Int): List<Lotto> {
            return List(price / PRICE) {
                Lotto(generateRandom())
            }
        }
    }
}
