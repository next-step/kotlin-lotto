package Lotto

import Lotto.controller.LottoController
import Lotto.domain.dto.ProfitRateRequest
import Lotto.domain.dto.StatisticsRequest

fun main() {
    val lottoController = LottoController()

    val purchaseAmount = lottoController.inputPurchaseAmount()
    val lottoTickets = lottoController.purchaseLottoTickets(purchaseAmount)
    val winningLotto = lottoController.inputWinningLotto()

    val lottoStatistics = lottoController.getStatistics(
        StatisticsRequest(lottoTickets, winningLotto)
    )

    lottoController.showLottoStatistics(lottoStatistics)
    lottoController.showProfitRate(
        ProfitRateRequest(purchaseAmount, lottoStatistics)
    )
}
