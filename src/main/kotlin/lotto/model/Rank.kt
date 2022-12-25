package lotto.model

enum class Rank(val match: Int, val reward: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_LUCK(0, 0);

    companion object {
        fun of(number: Int, matchBonus: Boolean): Rank {
            if (number == SECOND.match && matchBonus) {
                return SECOND
            }
            if (number == THIRD.match && !matchBonus) {
                return THIRD
            }
            return values().find { it.match == number } ?: NO_LUCK
        }
    }
}
