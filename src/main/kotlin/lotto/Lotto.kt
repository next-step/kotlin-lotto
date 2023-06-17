package lotto

class Lotto(
    private val numbers: List<Int>
) {

    fun getLotto(): List<Int> {
        return numbers.sorted()
    }

    companion object {
        const val ONE_PRICE: Int = 1000
        const val NUMBER_COUNT: Int = 6
    }
}
