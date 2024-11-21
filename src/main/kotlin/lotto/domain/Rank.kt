package lotto.domain

enum class Rank(
    val count: Int,
    val prize: Int,
) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun valueOf(count: Int): Rank =
            when {
                count == 6 -> FIRST
                count == 5 -> THIRD
                count == 4 -> FOURTH
                count == 3 -> FIFTH
                count in 0..2 -> MISS
                else -> throw IllegalArgumentException("${count}에 해당하는 등수가 없습니다.")
            }
    }
}
