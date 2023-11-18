package lotto.model

enum class LottoPrize(
    val matchedCount: Int,
    val prize: Int
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 150_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun of(matchedCount: Int): LottoPrize {
            return values().find { it.matchedCount == matchedCount } ?: MISS
        }
    }
}