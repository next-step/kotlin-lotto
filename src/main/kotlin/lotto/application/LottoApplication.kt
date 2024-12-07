package lotto.application

import lotto.view.LottoController

fun main() {
    val purchasedLottoTickets = LottoController.purchaseLotto()
    val lottoWinnerNumbers = LottoController.createWinningLottoNumbers()
    LottoController.resultPayout(purchasedLottoTickets = purchasedLottoTickets, lottoWinnerNumbers = lottoWinnerNumbers)
}
