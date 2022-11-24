package lotto.domain

enum class Reward(
    val matchCount: Int,
    val amount: Int
) {

    FIST_PLACE(6, 2_000_000_000),
    SECOND_BONUS_PLACE(5, 30_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FORTH_PLACE(3, 5_000);

    fun hasBonus() = this == SECOND_BONUS_PLACE
}
