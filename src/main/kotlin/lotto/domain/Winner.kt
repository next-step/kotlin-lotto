package lotto.domain

enum class Winner(
    val reward: Int,
    val matchCount: Int
) {
    FIRST_PLACE(2_000_000_000, 6),
    SECOND_PLACE_WITH_BONUS(30_000_000, 6),
    SECOND_PLACE(1_500_000, 5),
    THIRD_PLACE(50_000, 4),
    FOURTH_PLACE(5_000, 3);

    companion object {
        fun findWinner(lottoMatchCount: Int, rankMap: MutableMap<Winner, Int>) {
            Winner.values().find { winner ->
                winner.matchCount == lottoMatchCount
            }?.let { winner -> rankMap.put(winner,rankMap.getOrDefault(winner, 0) + 1) }
        }
    }
}
