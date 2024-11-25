package lotto.domain

enum class Rank(
    val count: Int,
    val prize: Int,
    val match: (Int, Boolean) -> Boolean,
) {
    FIRST(6, 2_000_000_000, { count, _ -> count == 6 }),
    SECOND(5, 30_000_000, { count, isBonusMatched -> count == 5 && isBonusMatched }),
    THIRD(5, 1_500_000, { count, _ -> count == 5 }),
    FOURTH(4, 50_000, { count, _ -> count == 4 }),
    FIFTH(3, 5_000, { count, _ -> count == 3 }),
    MISS(0, 0, { count, _ -> count in 0..2 }),
    ;

    companion object {
        fun valueOf(
            count: Int,
            isBonusMatched: Boolean,
        ): Rank =
            entries.firstOrNull { it.match(count, isBonusMatched) }
                ?: throw IllegalArgumentException("${count}에 해당하는 등수가 없습니다.")
    }
}
