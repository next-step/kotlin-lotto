package lotto

enum class LottoRank(
    val count: Int,
    val prizeMoney: Int
) {
    THREE_COLLECT(3, 5_000),
    FOUR_COLLECT(4, 50_000),
    FIVE_COLLECT(5, 1_500_000),
    SIX_COLLECT(6, 2_000_000_000)
}