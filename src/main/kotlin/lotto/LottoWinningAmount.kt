package lotto

enum class LottoWinningAmount(
    val matchCount: Int,
    val winningAmount: Long,
) {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);
}
