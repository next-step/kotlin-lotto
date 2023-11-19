package lotto.domain

data class LottoWinningResult(
    val lottoPrize: LottoPrize,
    val winningLottoCount: Int,
) {
    val totalWinningPrizeMoney: Long
        get() = lottoPrize.prizeMoney * winningLottoCount
}
