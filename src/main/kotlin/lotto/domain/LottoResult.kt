package lotto.domain

enum class LottoResult(
    val prize: Long,
    private val matchStrategy: (matchCount: Int, isBonusMatched: Boolean) -> Boolean
) {
    FIRST(2_000_000_000L, { matchCount, _ -> matchCount == 6 }),
    SECOND(30_000_000L, { matchCount, isBonusMatched -> matchCount == 5 && isBonusMatched }),
    THIRD(1_500_000L, { matchCount, isBonusMatched -> matchCount == 5 && !isBonusMatched }),
    FOURTH(50_000L, { matchCount, _ -> matchCount == 4 }),
    FIFTH(5_000L, { matchCount, _ -> matchCount == 3 }),
    LOSE(0L, { _, _ -> false });

    companion object {
        fun findByMatch(matchCount: Int, isBonusMatched: Boolean): LottoResult {
            return values().find { it.matchStrategy(matchCount, isBonusMatched) } ?: LOSE
        }
    }
}
