package lotto.domain

enum class Reward(
    private val matchNumber: Int,
    private val reward: Int
) {
    FIRST_RANK(6, 2000000000),
    SECOND_RANK(5, 1500000),
    THIRD_RANK(4, 50000),
    FOURTH_RANK(3, 5000), ;


    companion object {
        private const val NO_REWARD = 0

        fun getReward(matchNumber: Int): Int = values().find { it.matchNumber == matchNumber }?.reward ?: NO_REWARD
    }
}
