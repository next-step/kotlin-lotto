package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
    val needBonusMatch: Boolean
) {
    FIRTH(6, 2000000000, false),
    BONUS(5, 30000000, true),
    SECOND(5, 1500000, false),
    THIRD(4, 50000, false),
    FOURTH(3, 5000, false),
    DEFAULT(0, 0, false),
    ;

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): LottoRank {
            return when (matchCount) {
                6 -> FIRTH
                5 -> if (bonusMatch) BONUS else SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> DEFAULT
            }
        }
    }
}
