package lotto.domain

enum class Prize(val money: Int, val matchCount: Int, val matchBonus: Boolean = false) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    companion object {
        fun findPrize(count: Int, matchBonus: Boolean): Prize {
            val matchPrizes = values().filter { it.matchCount == count }
            return when (matchPrizes.size) {
                0 -> NONE
                1 -> matchPrizes[0]
                else -> matchPrizes.find { it.matchBonus == matchBonus }!!
            }
        }
    }
}
