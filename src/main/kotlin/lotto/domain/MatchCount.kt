package lotto.domain

enum class MatchCount(
    val matchCount: Int,
    val isMatchBonus: Boolean
) {
    ZERO(0, false),
    ONE(1, false),
    TWO(2, false),
    THREE(3, false),
    FOUR(4, false),
    FIVE(5, false),
    FIVE_WITH_BONUS(5, true),
    SIX(6, false);

    companion object {
        fun of(count: Int, isMatchBonus: Boolean): MatchCount {
            val matchCount = values().find { it.matchCount == count } ?: throw IllegalArgumentException("해당하는 매치 카운트가 없습니다.")
            if (matchCount == FIVE && isMatchBonus) {
                return FIVE_WITH_BONUS
            }
            return matchCount
        }
    }
}
