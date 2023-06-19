package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottos = Lottos.of(purchaseAmount, RandomLottoGenerator())

    ResultView.printLottoCount(lottos.size)
    ResultView.printLottos(lottos)

    val winningLottoNumbers = InputView.readWinningLottoNumbers()
    val bonusNumber = InputView.readBonusLottoNumber()
    val winningLotto = WinningLotto(winningLottoNumbers, bonusNumber)

    val lottoMachine = LottoMachine(lottos, winningLotto)

    ResultView.printWinnerStatistics(lottoMachine.matchWinningLottoPrize(), lottoMachine.getTotalProfitRate())
}
