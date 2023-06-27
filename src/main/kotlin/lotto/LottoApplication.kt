package lotto

import lotto.view.ConsoleView

fun main() {
    val lottoShopFacade = LottoShopFacade(listOf(ManualLottoShop(), RandomNumberLottoShop()))
    try {
        LottoGame(ConsoleView, ConsoleView, lottoShopFacade).run()
    } catch (e: IllegalArgumentException) {
        ConsoleView.showTerminationMessage(e.message)
    }
}
