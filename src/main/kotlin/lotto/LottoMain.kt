package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottos = Lottos.of(purchaseAmount, RandomLottoGenerator())

    ResultView.printLottoCount(lottos.size)
    ResultView.printLottos(lottos)

    val winningLotto = InputView.readWinningLotto()

    ResultView.printWinnerStatistics(lottos, winningLotto)
}
