package lotto

import lotto.view.ConsoleView

fun main() {
    LottoGame(ConsoleView, ConsoleView, RandomNumberLottoShop).run()
}
