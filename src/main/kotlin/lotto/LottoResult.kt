package lotto

class LottoResult {
    var prize: Prize = Prize.NONE
        private set

    fun check(matchCount: Int, matchBonus: Boolean): LottoResult {
        prize = Prize.getOrNull(
            matchCount = matchCount,
            matchBonus = matchBonus
        ) ?: Prize.NONE

        return this
    }

    enum class Prize(val matchCount: Int, val price: Int) {
        NONE(0, 0),
        FIRST(1, 0),
        SECOND(2, 0),
        THIRD(3, 5_000),
        FORTH(4, 50_000),
        FIFTH(5, 1_500_000),
        FIFTH_BONUS(6, 30_000_000),
        SIXTH(6, 2_000_000_000);

        companion object {
            fun getOrNull(matchCount: Int, matchBonus: Boolean): Prize? {
                return if (matchBonus) {
                    FIFTH_BONUS
                } else {
                    values().filter { it != FIFTH_BONUS }.firstOrNull { it.matchCount == matchCount }
                }
            }
        }
    }
}
