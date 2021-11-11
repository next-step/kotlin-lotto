package lotto.domain.enums

enum class PrizeType(
    val match: Int,
    val money: Int
) {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    companion object {
        fun findPrizeMoney(match: Int): Int {
            return values()
                .find { it.match == match }
                ?.money ?: 0
        }

        fun containsMatch(match: Int): Int {
            return values()
                .find { it.match == match }
                ?.match ?: 0
        }
    }
}
