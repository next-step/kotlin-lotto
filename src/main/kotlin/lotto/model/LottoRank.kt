package lotto.model

private const val RANK_MATCH_FIRST = 6
private const val RANK_MATCH_SECOND = 5
private const val RANK_MATCH_THIRD = 4
private const val RANK_MATCH_FOURTH = 3

enum class LottoRank(
    val price: Long,
    val matches: Int
) {
    FIRST(2_000_000_000, RANK_MATCH_FIRST),
    SECOND(1_500_000, RANK_MATCH_SECOND),
    THIRD(50_000, RANK_MATCH_THIRD),
    FOURTH(5_000, RANK_MATCH_FOURTH);

    companion object {
        fun find(matchCount: Int): LottoRank? = values().find { it.matches == matchCount }
    }
}
