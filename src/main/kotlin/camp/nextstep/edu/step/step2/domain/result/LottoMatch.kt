package camp.nextstep.edu.step.step2.domain.result

enum class LottoMatch(
    val matchCount: Int,
    val prize: Int
) {
    SIX_MATCH(6, 2_000_000_000),
    FIVE_MATCH(5, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(3, 5_000),
    NONE(0, 0);


    companion object {
        fun of(matchCount: Int): LottoMatch {
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
