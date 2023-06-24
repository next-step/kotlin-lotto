package step2Lotto

import step2Lotto.controller.LottoController
import step2Lotto.domain.dto.StatisticsRequest

fun main() {
    val lottoController = LottoController()

    val purchaseAmount = lottoController.inputPurchaseAmount()
    val lottoTickets = lottoController.purchaseLottoTickets(purchaseAmount)
    val winningLotto = lottoController.inputWinningLotto()

    val lottoStatistics = lottoController.getStatistics(
        StatisticsRequest(lottoTickets, winningLotto)
    )
}
