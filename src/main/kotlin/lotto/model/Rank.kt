package lotto.model

enum class Rank(val match: Int, val reward: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NO_LUCK(0, 0);

    companion object {
        fun of(number: Int, matchBonus: Boolean): Rank {
            if (matchBonus) {
                return SECOND
            }
            if (number == THIRD.match && !matchBonus) {
                return THIRD
            }
            return values().find { it.match == number } ?: NO_LUCK
        }
    }
}
