package lotto.domain

enum class LottoResult(
    val prize: Long,
    val matchCount: Int
) {
    FIRST(2_000_000_000L, 6),
    SECOND(30_000_000L, 5),
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3),
    LOSE(0L, -1);

    companion object {
        fun findByMatch(matchCount: Int, isBonusMatched: Boolean): LottoResult {
            if (matchCount == THIRD.matchCount) return when (isBonusMatched) {
                true -> SECOND
                false -> THIRD
            }
            return values().find { it.matchCount == matchCount } ?: LOSE
        }
    }
}
