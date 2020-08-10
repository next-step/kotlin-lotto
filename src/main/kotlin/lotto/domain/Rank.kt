package lotto.domain

private const val FIRST_REWARD = 2000000000
private const val SECOND_REWARD = 1500000
private const val THIRD_REWARD = 50000
private const val FOURTH_REWARD = 5000
private const val NONE_REWARD = 0

enum class Rank(val matches: Int, val prize: Int) {
    FIRST_PRIZE(6, FIRST_REWARD),
    SECOND_PRIZE(5, SECOND_REWARD),
    THIRD_PRIZE(4, THIRD_REWARD),
    FOURTH_PRIZE(3, FOURTH_REWARD),
    NONE(0, NONE_REWARD);

    companion object {
        fun of(count: Int): Rank {
            return Rank.values().find { it.matches == count } ?: NONE
        }
    }
}
