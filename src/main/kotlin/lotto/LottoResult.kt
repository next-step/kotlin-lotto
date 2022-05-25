package lotto

/**
 * 로또 결과
 */
class LottoResult(winningValue: String, lotto: Lotto) {
    private val winningNumbers = winningValue
        .replace(" ", "")
        .split(",")
        .map { it.toInt() }
        .intersect(lotto.numbers)

    val machCount = winningNumbers.size

    val prize = Prize.getOrNull(machCount) ?: 0

    enum class Prize(val machCount: Int, val price: Int) {
        THIRD(3, 5000),
        FORTH(4, 50000),
        FIFTH(5, 1500000),
        SIXTH(6, 2000000000);

        companion object {
            fun getOrNull(machCount: Int): Int? =
                values().firstOrNull() { it.machCount == machCount }?.price
        }
    }
}

