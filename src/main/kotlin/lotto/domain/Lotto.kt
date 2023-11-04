package lotto.domain

class Lotto {
    val numbers: List<Int> = List(NUMBER_COUNT) { it }

    companion object {
        const val PRICE = 1000
        private const val NUMBER_COUNT = 6
    }
}
