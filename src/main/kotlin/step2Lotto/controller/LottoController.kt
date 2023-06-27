package step2Lotto.controller

import step2Lotto.domain.*
import step2Lotto.domain.dto.ProfitRateRequest
import step2Lotto.domain.dto.StatisticsRequest
import step2Lotto.view.InputIO
import step2Lotto.view.InputMessage
import step2Lotto.view.InputView
import step2Lotto.view.ResultView

class LottoController {
    private val inputIO = InputIO()
    private val inputView = InputView()
    private val lottoStatisticService = LottoStatisticService()
    private val lottoStore = LottoStore(AutoLottoGenerator())
    private val resultView = ResultView()

    fun inputPurchaseAmount(): Int {
        inputView.show(InputMessage.PURCHASE_AMOUNT)
        return inputIO.inputPurchaseAmount()
    }

    fun purchaseLottoTickets(purchaseAmount: Int): List<Lotto> {
        val lottoTickets = lottoStore.purchaseLottoTickets(purchaseAmount)
        resultView.showLottoTicketQuantity(lottoTickets.size)
        resultView.showLottoTickets(lottoTickets)
        return lottoTickets
    }

    fun inputWinningLotto(): WinningNumber {
        inputView.show(InputMessage.WINNING_LOTTO)
        return inputIO.inputWinningNumber()
    }

    fun getStatistics(req: StatisticsRequest): List<LottoRank> {
        return lottoStatisticService.getStatistics(req)
    }

    fun showLottoStatistics(statistics: List<LottoRank>) {
        resultView.showLottoStatistics(statistics)
    }

    fun showProfitRate(req: ProfitRateRequest) {
        val profitRate = lottoStatisticService.getProfitRate(req)
        resultView.showProfitRate(profitRate)
    }
}
