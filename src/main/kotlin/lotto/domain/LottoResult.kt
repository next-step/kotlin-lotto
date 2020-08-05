package lotto.domain

enum class LottoResult(
    val prize: Long,
    val matchCount: Int
) {
    FIRST(2_000_000_000L, 6),
    SECOND_BONUS(30_000_000L, 5),
    SECOND(1_500_000L, 5),
    THIRD(50_000L, 4),
    FOURTH(5_000L, 3),
    LOSE(0L, -1);

    companion object {
        fun findByMatch(matchCount: Int, isBonusMatched: Boolean): LottoResult {
            if (matchCount == SECOND.matchCount) return when (isBonusMatched) {
                true -> SECOND_BONUS
                false -> SECOND
            }
            return values().find { it.matchCount == matchCount } ?: LOSE
        }
    }
}
