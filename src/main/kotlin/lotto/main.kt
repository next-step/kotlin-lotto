package lotto

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()

    val purchasedLottoList = LottoMachine().purchase(purchaseAmount)

    ResultView.showPurchasedLotto(purchasedLottoList)

    val lastWinnerLotto = InputView.getLastWinnerLotto()

    val lottoStatResult = LottoStatCalculator(lastWinnerLotto).getStat(purchasedLottoList)

    ResultView.showLottoStatResult(lottoStatResult)
}
