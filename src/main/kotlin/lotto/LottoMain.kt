package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottos = Lottos.of(purchaseAmount, RandomLottoGenerator())

    ResultView.printLottoCount(lottos.size)
    ResultView.printLottos(lottos)

    val winningLotto = InputView.readWinningLotto()
    val bonusNumber = InputView.readBonusLottoNumber()
    val bonusLottoNumber = LottoNumber.forBonusOf(bonusNumber, winningLotto)

    val lottoMachine = LottoMachine(lottos, winningLotto, bonusLottoNumber)

    ResultView.printWinnerStatistics(lottoMachine.matchWinningLottoPrize(), lottoMachine.getTotalProfitRate())
}
