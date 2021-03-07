package lotto

enum class Rank(private val matchCount: Int, val winningMoney: Long) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),

    MISS(0, 0);

    companion object {
        fun find(matchCount: Int): Rank {
            return values().firstOrNull { it.matchCount == matchCount }
                ?: Rank.MISS
        }
    }
}
