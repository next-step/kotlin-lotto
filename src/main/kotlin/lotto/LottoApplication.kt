package lotto

import lotto.view.ConsoleView

fun main() {
    try {
        LottoGame(ConsoleView, ConsoleView, RandomNumberLottoShop).run()
    } catch (e: IllegalArgumentException) {
        ConsoleView.showTerminationMessage(e.message)
    }
}
