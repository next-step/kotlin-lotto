package lotto.domain

enum class Reward(val match: Int, val reward: Int) {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 200000000);

    companion object {
        fun find(match: Int) = Reward.values()
            .find { it.match == match }
    }
}
