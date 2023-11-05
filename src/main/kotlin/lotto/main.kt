package lotto

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()

    val purchasedLottoList = LottoMachine().purchase(purchaseAmount)

    ResultView.showPurchasedLotto(purchasedLottoList)

    val lastWinnerLotto = InputView.getLastWinnerLotto()
}
