package lotto.domain

enum class WinningPlace(
    val reward: Int,
    private val requiredMatchingCount: Int,
) {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    BLANK(0, 2);

    companion object {
        fun of(matchingCount: Int): WinningPlace {
            if (matchingCount <= BLANK.requiredMatchingCount) return BLANK
            return values().find { it.requiredMatchingCount == matchingCount }
                ?: throw IllegalArgumentException("당첨 개수에 해당하는 등수가 없습니다")
        }
    }
}
