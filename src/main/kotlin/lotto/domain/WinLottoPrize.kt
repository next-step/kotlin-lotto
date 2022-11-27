package lotto.domain

enum class WinLottoPrize(
    val hitCount: Int,
    val prizeMoney: Int
) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    companion object {
        val MINIMUM_HIT_COUNT: Int = values().minOf { it.hitCount }

        fun from(hitCount: Int): WinLottoPrize {
            return values().first { it.hitCount == hitCount }
        }
    }
}
