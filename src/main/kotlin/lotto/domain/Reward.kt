package lotto.domain

enum class Reward(
    val hitCount: Int,
    val prizeMoney: Int
) {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_5000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        val MINIMUM_HIT_COUNT: Int = values().minOf { it.hitCount }

        fun from(hitCount: Int): Reward {
            return values().first { it.hitCount == hitCount }
        }
    }
}
