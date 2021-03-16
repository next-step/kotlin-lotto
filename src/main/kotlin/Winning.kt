enum class Winning(val price: Int, val match: Int) {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0, 0);

    companion object {
        fun matchWinning(match: Int, hasBonus: Boolean): Winning {
            val winning = values().firstOrNull { it.match == match } ?: NONE
            if (winning == SECOND && !hasBonus) {
                return THIRD
            }
            return winning
        }
    }
}
