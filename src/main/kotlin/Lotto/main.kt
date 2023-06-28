package Lotto

import Lotto.controller.LottoController
import Lotto.domain.WinningLotto
import Lotto.domain.dto.ProfitRateRequest
import Lotto.domain.dto.StatisticsRequest

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
