package domain

enum class Prize(
    val matches: Int,
    val prize: Int
) {
    MATCH_3(3, 5_000),
    MATCH_4(4, 50_000),
    MATCH_5(5, 1_500_000),
    MATCH_6(6, 2_000_000_000);

    companion object {
        fun getPrizeForMatches(matches: Int) = values().firstOrNull { it.matches == matches }?.prize ?: 0
    }
}
