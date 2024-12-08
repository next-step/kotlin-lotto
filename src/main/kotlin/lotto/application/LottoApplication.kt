package lotto.application

import lotto.controller.LottoController

fun main() {
    val purchasedLottoTickets = LottoController.purchaseLotto()
    val lottoWinnerNumbers = LottoController.createWinningLottoNumbers()
    LottoController.resultPayout(purchasedLottoTickets = purchasedLottoTickets, lottoWinnerNumbers = lottoWinnerNumbers)
}
