package lotto.domain

data class Lotto(val numbers: List<Int>) {
    override fun toString(): String = numbers.joinToString(", ", "[", "]")

    enum class WinningPrize(val count: Int, val prize: Int) {
        THREE(3, 5000),
        FOUR(4, 50000),
        FIVE(5, 1500000),
        SIX(6, 2000000000);

        companion object {
            fun of(count: Int): WinningPrize {
                return values().first { it.count == count }
            }
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_WINNING_MIN_COUNT = 3
    }
}
