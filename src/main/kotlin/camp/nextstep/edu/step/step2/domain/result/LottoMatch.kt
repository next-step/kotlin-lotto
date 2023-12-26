package camp.nextstep.edu.step.step2.domain.result

enum class LottoMatch(
    val matchCount: Int,
    val bonusMatch: Int,
    val prize: Int
) {
    SIX_MATCH(6, 0, 2_000_000_000),
    FIVE_MATCH(5, 0, 1_500_000),
    FIVE_MATCH_WITH_BONUS(5, 1, 30_000_000),
    FOUR_MATCH(4, 0, 50_000),
    THREE_MATCH(3, 0, 5_000),
    NONE(0, 0, 0);


    companion object {
        fun of(matchCount: Int, bonusMatch: Int): LottoMatch {
            return values().find { it.matchCount == matchCount && it.bonusMatch == bonusMatch }
                ?: NONE
        }
    }
    
}
