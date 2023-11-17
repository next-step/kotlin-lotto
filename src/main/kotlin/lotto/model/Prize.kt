package lotto.model

enum class Prize(
    val matched: Int, val prize: Int, val bonus: Boolean = false
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun getKeyWithMatched(matched: Int, bonus: Boolean): Prize =
            Prize.values().find { it.matched == matched && it.bonus == bonus } ?: MISS

        fun isBonus(matched: Int, bonus: Boolean) =
            matched == SECOND.matched && SECOND.bonus == bonus
    }
}
