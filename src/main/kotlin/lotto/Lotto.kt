package lotto

import lotto.number.Numbers

data class Lotto(
    val numbers: Numbers =
        Numbers(
            RANGE
                .shuffled()
                .take(COUNT)
                .sorted(),
        ),
) {
    companion object {
        private const val COUNT = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private val RANGE = (MIN_NUMBER..MAX_NUMBER).toList()
        const val PRICE: Int = 1_000
    }
}
