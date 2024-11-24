package lotto.domain

enum class Rank(
    val count: Int,
    val prize: Int,
    val match: (Int) -> Boolean,
) {
    FIRST(6, 2_000_000_000, { it == 6 }),
    THIRD(5, 1_500_000, { it == 5 }),
    FOURTH(4, 50_000, { it == 4 }),
    FIFTH(3, 5_000, { it == 3 }),
    MISS(0, 0, { it in 0..2 }),
    ;

    companion object {
        fun valueOf(count: Int): Rank =
            entries.firstOrNull { it.match(count) } ?: throw IllegalArgumentException("${count}에 해당하는 등수가 없습니다.")
    }
}
