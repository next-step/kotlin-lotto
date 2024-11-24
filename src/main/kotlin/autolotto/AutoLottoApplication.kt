package autolotto

import autolotto.view.InputView

val inputView = InputView()
fun main() {
    val amount = inputView.getLottoPurchaseAmount()
    val gameCount = inputView.getLottoGameCount(amount)

//    val winningNumbers = inputView.getWinningNumber()
}
