package lotto

class Ranking(match: Match) {
    val rank: Rank = Rank.of(match.count)

    constructor(theNumber: LottoNumber, other: LottoNumber) : this(Match(theNumber, other))

    enum class Rank(val matchCount: Int = 0, val amount: Long = 0) {
        FOURTH(3, 5_000L),
        THIRD(4, 50_000L),
        SECOND(5, 1_500_000L),
        FIRST(6, 2_000_000_000L),
        MISS;

        fun prize(count: Int): Long = amount * count
        private fun same(count: Int): Boolean = matchCount == count

        companion object {
            fun of(count: Int): Rank = values().firstOrNull { it.same(count) } ?: MISS
        }
    }
}
