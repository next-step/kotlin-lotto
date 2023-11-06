package autolotto

import autolotto.ui.InputView
import autolotto.ui.ResultView

fun main() {
    startAutoLotto()
}

fun startAutoLotto() {
    try {
        val autoLotto = InputView.promptForAutoLotto()
        val winningLotto = InputView.promptForWinningLotto()
        ResultView.printWinningPoints(autoLotto, winningLotto)
    } catch (e: Exception) {
        println(e.message)
        startAutoLotto()
    }
}
