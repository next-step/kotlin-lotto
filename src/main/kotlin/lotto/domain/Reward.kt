package lotto.domain

enum class Reward(val count: Int) {
    `5000`(3), `50000`(4), `1500000`(5), `2000000000`(6);

    companion object {
        fun find(count: Int) = Reward.values().find { it.count == count }
    }
}
