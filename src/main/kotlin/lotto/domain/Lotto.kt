package lotto.domain

data class Lotto(val numbers: List<Int>) {

    init {
        require(validateNumbers())
    }

    private fun validateNumbers(): Boolean {
        numbers.distinct().also {
            return it.size == 6 && it.filterNot { number -> number in NUMBER_RANGE }.isEmpty()
        }
    }

    companion object {
        private const val NUMBER_RANGE_START = 1
        private const val NUMBER_RANGE_END = 45
        private val NUMBER_RANGE = NUMBER_RANGE_START..NUMBER_RANGE_END

        fun buyRandom(price: Int): List<Lotto> { return emptyList() }
    }
}
