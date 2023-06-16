package lotto

enum class LottoEnum(
    val count: Int,
    val prizeMoney: Int
) {
    THREE_COLLECT(3, 5000),
    FOUR_COLLECT(4, 50000),
    FIVE_COLLECT(5, 1500000),
    SIX_COLLECT(6, 2000000000)
}