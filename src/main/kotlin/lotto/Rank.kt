package lotto

enum class Rank(val matchCount: Int, val reward: Int) {

    ALLMATCH(6, 2_000_000_000),
    FIVEMATCH(5, 1_500_000),
    FOURMATCH(4, 50_000),
    THREEMATCH(3, 5_000),
    NONE(0, 0);

    fun resultLottoPrize(count: Int): Rank {
        return Rank.findMatchCount(count)
    }

    companion object {
        fun findMatchCount(matchCount: Int): Rank {
            return enumValues<Rank>().firstOrNull() { it.matchCount == matchCount } ?: NONE
        }
    }
}
