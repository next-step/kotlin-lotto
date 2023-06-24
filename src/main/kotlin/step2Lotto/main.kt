package step2Lotto

import step2Lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()

    val purchaseAmount = lottoController.inputPurchaseAmount()
    val lottoTickets = lottoController.purchaseLottoTickets(purchaseAmount)
}
