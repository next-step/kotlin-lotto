package lotto.model

enum class LottoRank(
    val price: Long,
    val matches: Int,
    val bonusMatches: Boolean = false
) {

    FIRST(
        price = 2_000_000_000,
        matches = 6
    ),

    SECOND(
        price = 30_000_000,
        matches = 5,
        bonusMatches = true
    ),

    THIRD(
        price = 1_500_000,
        matches = 5
    ),

    FOURTH(
        price = 50_000,
        matches = 4
    ),

    FIFTH(
        price = 5_000,
        matches = 3
    );

    companion object {
        fun find(matchResult: MatchResult): LottoRank? =
            values().find { it.matches == matchResult.match && it.bonusMatches == matchResult.bonusMatch }
    }
}
