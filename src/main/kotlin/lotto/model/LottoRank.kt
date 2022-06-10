package lotto.model

enum class LottoRank(
    val price: Long,
    val matches: Int,
    val bonusMatches: Boolean
) {

    FIRST(
        price = 2_000_000_000,
        matches = 6,
        bonusMatches = false
    ),

    SECOND(
        price = 30_000_000,
        matches = 5,
        bonusMatches = true
    ),

    THIRD(
        price = 1_500_000,
        matches = 5,
        bonusMatches = false
    ),

    FOURTH(
        price = 50_000,
        matches = 4,
        bonusMatches = false
    ),

    FIFTH(
        price = 5_000,
        matches = 3,
        bonusMatches = false
    );

    companion object {
        fun find(matchCount: Pair<Int, Boolean>): LottoRank? =
            values().find { it.matches == matchCount.first && it.bonusMatches == matchCount.second }
    }
}
