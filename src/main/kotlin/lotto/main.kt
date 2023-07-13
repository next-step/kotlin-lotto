package lotto

import lotto.controller.LottoController
import lotto.domain.dto.ProfitRateRequest
import lotto.domain.dto.StatisticsRequest

fun main() {
    val lottoController = LottoController()

    val purchaseAmount = lottoController.inputPurchaseAmount()
    val manualLottoCount = lottoController.inputManualLottoCount()
    val manualLottoNumbers = lottoController.inputManualLottoNumbers(manualLottoCount)

    val purchaseLottoRequest = lottoController.createPurchaseLottoRequest(purchaseAmount, manualLottoCount, manualLottoNumbers)

    val lottoTickets = lottoController.purchaseLottoTickets(purchaseLottoRequest)
    val winningLotto = lottoController.inputWinningLotto()

    val lottoStatistics = lottoController.getStatistics(
        StatisticsRequest(lottoTickets, winningLotto)
    )

    lottoController.showLottoStatistics(lottoStatistics)
    lottoController.showProfitRate(
        ProfitRateRequest(purchaseAmount, lottoStatistics)
    )
}
