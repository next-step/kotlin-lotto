package lotto.domain

class Lotto(
    val numbers: List<Int>
) {

    companion object {
        const val DEFAULT_PRICE: Int = 1000

        fun affordableLottoCount(budget: Int): Int {
            return budget / DEFAULT_PRICE
        }
    }
}
