enum class Winning(val price: Int, val match: Int) {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0, 0);

    fun getCondition(): String {
        val bonusText = if (this == SECOND) ", 보너스 볼 일치" else ""
        return "${match}개 일치$bonusText (${price}원)"
    }

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
