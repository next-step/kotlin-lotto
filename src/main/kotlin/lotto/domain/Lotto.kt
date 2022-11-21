package lotto.domain

class Lotto(
    val numbers: List<Int>
) {
    companion object {
        private const val LOTTO_PRICE = 1000
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBERS_SIZE = 6

        val PRIZE_MONEY_PER_HIT_COUNT = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )

        fun calculateLottoCount(payment: Int): Int {
            return payment / LOTTO_PRICE
        }
    }
}
