package lotto.domain

enum class LottoRank(val count: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000),
    MISS(0, 0);

    companion object {
        fun of(count: Int, matchBonus: Boolean): LottoRank {
            return when {
                isSecondOrThird(count) && matchBonus -> SECOND
                isSecondOrThird(count) && matchBonus.not() -> THIRD
                else -> values().firstOrNull { it.count == count } ?: MISS
            }
        }

        private fun isSecondOrThird(count: Int): Boolean {
            return count == SECOND.count
        }
    }
}
