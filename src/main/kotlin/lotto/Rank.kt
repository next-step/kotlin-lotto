package lotto

enum class Rank(val matchCount: Int, val reward: Int) {

    ALL_MATCH(6, 2_000_000_000),
    FIVE_MATCH(5, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(3, 5_000),
    NONE(0, 0);

    fun resultLottoPrize(count: Int): Rank {
        return Rank.findMatchCount(count)
    }

    companion object {
        fun findMatchCount(matchCount: Int): Rank {
            return enumValues<Rank>().firstOrNull { it.matchCount == matchCount } ?: NONE
        }
    }
}
