package lotto.domain

enum class Reward(
    val matchNumber: Int,
    val reward: Int
) {
    FIRST_RANK(6, 2000000000),
    SECOND_RANK(6, 30000000),
    THIRD_RANK(5, 1500000),
    FOURTH_RANK(4, 50000),
    FIFTH_RANK(3, 5000),
    NO_RANK(-1, 0);

    companion object {
        fun getReward(matchNumber: Int, hasBonusBall: Boolean): Reward {
            if (isBonusReward(matchNumber, hasBonusBall)) {
                return SECOND_RANK
            }
            return values().find { it.matchNumber == matchNumber } ?: NO_RANK
        }

        private fun isBonusReward(matchNumber: Int, hasBonusBall: Boolean) =
            matchNumber == THIRD_RANK.matchNumber && hasBonusBall
    }
}
