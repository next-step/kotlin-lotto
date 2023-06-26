package step2Lotto.controller

import step2Lotto.domain.AutoLottoGenerator
import step2Lotto.domain.LottoService
import step2Lotto.domain.LottoStore
import step2Lotto.domain.Lotto
import step2Lotto.domain.LottoRank
import step2Lotto.domain.dto.ProfitRateRequest
import step2Lotto.domain.dto.StatisticsRequest
import step2Lotto.view.InputIO
import step2Lotto.view.InputMessage
import step2Lotto.view.InputView
import step2Lotto.view.ResultView

class LottoController {
    private val inputIO = InputIO()
    private val inputView = InputView()
    private val lottoService = LottoService()
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

    fun inputWinningLotto(): Lotto {
        inputView.show(InputMessage.WINNING_LOTTO)
        return inputIO.inputWinningNumber()
    }

    fun getStatistics(req: StatisticsRequest): List<LottoRank> {
        return lottoService.getStatistics(req)
    }

    fun showLottoStatistics(statistics: List<LottoRank>) {
        resultView.showLottoStatistics(statistics)
    }

    fun showProfitRate(req: ProfitRateRequest) {
        val profitRate = lottoService.getProfitRate(req)
        resultView.showProfitRate(profitRate)
    }
}
