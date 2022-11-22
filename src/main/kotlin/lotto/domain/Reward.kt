package lotto.domain

enum class Reward(
    val matchCount: Int,
    val amount: Int
) {
    MATCH_THREE(3, 5_000),
    MATCH_FOUR(4, 50_000),
    MATCH_FIV(5, 1_500_000),
    MATCH_SIX(6, 2_000_000_000);
}
