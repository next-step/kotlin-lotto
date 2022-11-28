package lotto.domain

enum class Reward(
    val matchNumber: Int,
    val reward: Int
) {
    FIRST_RANK(6, 2000000000),
    SECOND_RANK(5, 1500000),
    THIRD_RANK(4, 50000),
    FOURTH_RANK(3, 5000),
    NO_RANK(-1, 0);

    companion object {
        fun getReward(matchNumber: Int): Reward = values().find { it.matchNumber == matchNumber } ?: NO_RANK
    }
}
