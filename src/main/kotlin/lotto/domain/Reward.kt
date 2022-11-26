package lotto.domain

enum class Reward(
    val matchCount: Int,
    val amount: Int,
    val hasBonus: Boolean
) {
    FIST_PLACE(6, 2_000_000_000, false),
    SECOND_PLACE(5, 30_000_000, true),
    THIRD_PLACE(5, 1_500_000, false),
    FOURTH_PLACE(4, 50_000, false),
    FIVE_PLACE(3, 5_000, false);
}
