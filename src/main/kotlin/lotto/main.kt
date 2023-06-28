package lotto

import lotto.controller.LottoController
import lotto.domain.WinningLotto
import lotto.domain.dto.ProfitRateRequest
import lotto.domain.dto.StatisticsRequest

fun main() {
    val lottoController = LottoController()

    val purchaseAmount = lottoController.inputPurchaseAmount()
    val lottoTickets = lottoController.purchaseLottoTickets(purchaseAmount)
    val winningNumbers = lottoController.inputWinningNumber()
    val bonusNumber = lottoController.inputBonusNumber()



    val lottoStatistics = lottoController.getStatistics(
        StatisticsRequest(lottoTickets, WinningLotto(winningNumbers, bonusNumber))
    )

    lottoController.showLottoStatistics(lottoStatistics)
    lottoController.showProfitRate(
        ProfitRateRequest(purchaseAmount, lottoStatistics)
    )
}
