package step2Lotto

import step2Lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()

    val purchaseAmount = lottoController.inputPurchaseAmount()
    lottoController.purchaseLottoTickets(purchaseAmount)
}