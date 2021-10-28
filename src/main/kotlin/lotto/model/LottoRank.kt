package lotto.model

private const val RANK_MATCH_FIRST = 6
private const val RANK_MATCH_SECOND = 5
private const val RANK_MATCH_THIRD = 4
private const val RANK_MATCH_FOURTH = 3
private const val RANK_MATCH_FIFTH = 2

enum class LottoRank(
    val winnings: Int,
    private val match: Int
) {
    First(2_000_000_000, RANK_MATCH_FIRST),
    Second(1_500_000, RANK_MATCH_SECOND),
    Third(50_000, RANK_MATCH_THIRD),
    Fourth(10_000, RANK_MATCH_FOURTH),
    Fifth(5_000, RANK_MATCH_FIFTH);

    companion object {
        fun find(match: Int): LottoRank? = values().find { it.match == match }
    }
}
