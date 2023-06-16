package lotto.domain

enum class LottoPrize(
    val reward: Int,
    val matchCount: Int,
) {
    FIRST(2_000_000_000, 6),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
}
