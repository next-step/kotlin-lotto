package lotto.model

enum class LottoPrize(val matchingCount: Int, val prizeAmount: Long) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    companion object {
        private const val PRIZING_CONT = 3
        fun getPrizeAmount(matchingCount: Int): Long {
            check(matchingCount >= PRIZING_CONT) { return 0 }
            return values().find { it.matchingCount == matchingCount }!!.prizeAmount
        }
    }
}
