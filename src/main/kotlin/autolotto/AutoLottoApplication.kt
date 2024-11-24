package autolotto

import autolotto.view.InputView

val inputView = InputView()
//val  = InputView()
fun main() {
    val gameCount = inputView.getLottoGameCount()
    val winningNumbrs = inputView.getWinningNumber()
}
