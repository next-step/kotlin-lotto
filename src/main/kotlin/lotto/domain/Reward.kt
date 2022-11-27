package lotto.domain

enum class Reward(
    val matchCount: Int,
    val amount: Int,
    val hasBonus: Boolean = false
) {
    FIST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000, true),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIVE_PLACE(3, 5_000);

    companion object {
        private val Rewards = Reward.values().associateBy { it.matchCount to it.hasBonus }

        fun from(matchCount: Int, hasBonus: Boolean): Reward? = Rewards[matchCount to hasBonus]
    }
}
