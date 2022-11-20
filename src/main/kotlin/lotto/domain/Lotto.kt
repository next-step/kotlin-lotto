package lotto.domain

class Lotto(
    val numbers: List<Int>
) {
    companion object {
        private const val LOTTO_PRICE = 1000
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBERS_SIZE = 6

        fun calculateLottoCount(payment: Int): Int {
            return payment / LOTTO_PRICE
        }
    }
}
