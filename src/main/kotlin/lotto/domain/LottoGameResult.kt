package lotto.domain

class LottoGameResult(
    purchaseMoney: Long,
    winningLottoNumbers: Set<Int>,
    lottos: List<Lotto>,
) {
    val lottoWinningResults: List<LottoWinningResult>
    val totalRateOfReturn: Double

    init {
        lottoWinningResults = LottoPrize.values().map { lottoPrize ->
            val winningLottoCount = lottos.filter { it.matchNumberCount(winningLottoNumbers) == lottoPrize.matchCount }.size
            LottoWinningResult(
                lottoPrize = lottoPrize,
                winningLottoCount = winningLottoCount
            )
        }

        val totalLottoPrizeMoney = lottoWinningResults
            .sumOf { it.totalWinningPrizeMoney }

        totalRateOfReturn = totalLottoPrizeMoney.toDouble() / purchaseMoney.toDouble()
    }
}
