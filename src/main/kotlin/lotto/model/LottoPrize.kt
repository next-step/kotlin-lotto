package lotto.model

enum class LottoPrize(val matchingCount: Int, val prizeAmount: Long) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE_PRIZE(0, 0);

    companion object {
        private const val PRIZING_CONT = 3
        fun getLottoPrize(matchingCount: Int): LottoPrize {
            check(matchingCount >= PRIZING_CONT) { return NONE_PRIZE }
            return values().find { it.matchingCount == matchingCount }!!
        }
    }
}
