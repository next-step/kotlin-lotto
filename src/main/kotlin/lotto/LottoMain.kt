package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottos = Lottos.of(purchaseAmount, RandomLottoGenerator())

    ResultView.printLottoCount(lottos.size)
    ResultView.printLottos(lottos)

    val winningLotto = InputView.readWinningLotto()
    val bonusLottoNumber = InputView.readBonusLottoNumber()

    val prizes = lottos.getWinningCountsByPrize(winningLotto, bonusLottoNumber)
    val winningLottoPrizeVOs = prizes.map { (prize, winningLottoCount) ->
        WinningLottoPrizeVO(
            matchedCount = prize.matchedCount,
            prizeAmount = prize.prizeAmount,
            winningLottoCount = winningLottoCount,
            bonusMatched = prize.isBonusMatched(),
        )
    }
    val totalProfitRate = lottos.getTotalProfitRate(winningLotto, bonusLottoNumber)

    ResultView.printWinnerStatistics(winningLottoPrizeVOs, totalProfitRate)
}
