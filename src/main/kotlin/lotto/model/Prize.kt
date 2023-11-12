package lotto.model

enum class Prize(
    val matched: Int, val prize: Int
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun getKeyWithMatched(matched: Int, bonus: Boolean): Prize {
            return when{
                FIRST.matched == matched -> FIRST
                SECOND.matched == matched && bonus -> SECOND
                THIRD.matched == matched -> THIRD
                FOURTH.matched == matched -> FOURTH
                FIFTH.matched == matched -> FIFTH
                else -> MISS
            }

        }
    }
}
