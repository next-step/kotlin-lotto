package next.step.lotto.domain

enum class LottoRank(val matchCount: Int, val winnings: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    fun shouldMatchBonus(): Boolean = this == SECOND

    companion object {

        fun from(matchCount: Int, matchBonus: Boolean): LottoRank {
            return if (isSecond(matchBonus, matchCount)) SECOND
            else values().filterNot { it.shouldMatchBonus() }.find { it.matchCount == matchCount } ?: MISS
        }

        private fun isSecond(matchBonus: Boolean, matchCount: Int): Boolean =
            matchBonus && matchCount == SECOND.matchCount

    }

}
