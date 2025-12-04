package domain

enum class LottoWinningType(val priceMoney: Int, val matchingCount: Int, val requireBonus: Boolean = false) {
    FIRST(2000000000, 6),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0, 0),
    ;

    companion object {
        fun fromMatchCount(
            matchingCount: Int,
            hasBonus: Boolean,
        ): LottoWinningType {
            if (matchingCount == 5 && hasBonus) return SECOND
            return entries.find { it.matchingCount == matchingCount && !it.requireBonus } ?: NONE
        }
    }
}
