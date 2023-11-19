package lotto

import lotto.domain.LottoIssuer
import lotto.domain.LottoPrize
import lotto.domain.LottoWinningResult
import lotto.view.InputView
import lotto.view.ResultView

fun main() {

    val purchaseMoney = InputView.inputPurchaseMoney()

    val lottoIssuer = LottoIssuer()
    val lottos = lottoIssuer.issueLottoByAuto(purchaseMoney)

    ResultView.printPurchasedLottos(lottos)

    val winningLottoNumbers = InputView.inputWinningLottoNumbers()

    val lottoWinningResults = mutableListOf<LottoWinningResult>()
    LottoPrize.values().forEach { lottoPrize ->
        val winningLottoCount = lottos.filter { it.matchNumberCount(winningLottoNumbers) == lottoPrize.matchCount }.size
        val lottoWinningResult = LottoWinningResult(
            lottoPrize = lottoPrize,
            winningLottoCount = winningLottoCount
        )
        lottoWinningResults.add(lottoWinningResult)
    }

    val totalLottoPrizeMoney = lottoWinningResults
        .sumOf { it.totalWinningPrizeMoney }

    val totalRateOfReturn = totalLottoPrizeMoney.toDouble() / purchaseMoney.toDouble()

    ResultView.printWinningStatistics(lottoWinningResults)
    ResultView.printTotalRateOfReturn(totalRateOfReturn)
}
