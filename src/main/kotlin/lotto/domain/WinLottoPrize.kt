package lotto.domain

enum class WinLottoPrize(
    val hitCount: Int,
    val money: Int
) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    companion object {
        private val HIT_COUNT_TO_PRIZE_MAP = WinLottoPrize.values().associateBy(WinLottoPrize::hitCount, WinLottoPrize::money)

        fun getPrizeMoney(count: Int): Int {
            return HIT_COUNT_TO_PRIZE_MAP.getOrDefault(count, 0)
        }
    }
}
