package lotto.application

import lotto.controller.LottoController

fun main() {
    val maxPurchaseLottoCount = LottoController.getMaxPurchaseLottoCountFromPayment()
    val manualLottoTickets = LottoController.purchaseManualLotto(maxPurchaseLottoCount)
    val totalLottoTickets = LottoController.createAutoLotto(maxPurchaseLottoCount, manualLottoTickets)
    val lottoWinnerNumbers = LottoController.createWinningLottoNumbers()

    LottoController.resultPayout(lottoTickets = totalLottoTickets, lottoWinnerNumbers = lottoWinnerNumbers)
}
