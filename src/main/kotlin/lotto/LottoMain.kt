package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottos = Lottos.of(purchaseAmount, RandomLottoGenerator())

    ResultView.printLottoCount(lottos.size)
    ResultView.printLottos(lottos)

    val winningLotto = InputView.readWinningLotto()

    val winningLottoCountsByPrize: Map<Prize, Int> = Prize.getWinningLottoCountsByPrize(lottos, winningLotto)
    val winningLottoPrizeVOs = winningLottoCountsByPrize.map { (prize, winningLottoCount) ->
        WinningLottoPrizeVO(
            matchedCount = prize.matchedCount,
            prizeAmount = prize.prizeAmount,
            winningLottoCount = winningLottoCount,
        )
    }
    val totalProfitRate = lottos.getTotalProfitRate(winningLotto)
    ResultView.printWinnerStatistics(winningLottoPrizeVOs, totalProfitRate)
}
