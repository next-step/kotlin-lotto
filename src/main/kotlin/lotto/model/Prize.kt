package lotto.model

enum class Prize(
    val matched: Int, val prize: Int, val bonus: Boolean
) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    companion object {
        fun getKeyWithMatched(matched: Int, bonus: Boolean): Prize = when {
            FIRST.matched == matched && FIRST.bonus == bonus -> FIRST
            SECOND.matched == matched && SECOND.bonus == bonus -> SECOND
            THIRD.matched == matched && THIRD.bonus == bonus -> THIRD
            FOURTH.matched == matched && FOURTH.bonus == bonus -> FOURTH
            FIFTH.matched == matched && FIFTH.bonus == bonus -> FIFTH
            else -> MISS
        }

        fun isBonus(matchCount: Int, numbers: List<LottoNumber>, bonusNumber: LottoNumber) =
            matchCount == SECOND.matched && numbers.contains(bonusNumber)
    }
}
