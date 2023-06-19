package lotto.domain

enum class LottoRank(val price: Int, val matchingCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    NONE(0, 2) {
        override fun isMatch(count: Int) = count <= matchingCount
    };

    open fun isMatch(count: Int): Boolean = this.matchingCount == count

    companion object {
        fun of(matchingCount: Int): LottoRank {
            return values().first { it.isMatch(matchingCount) }
        }
    }
}
