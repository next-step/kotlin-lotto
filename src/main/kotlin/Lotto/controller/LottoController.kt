package Lotto.controller

import Lotto.domain.*
import Lotto.domain.dto.ProfitRateRequest
import Lotto.domain.dto.StatisticsRequest
import Lotto.view.InputIO
import Lotto.view.InputMessage
import Lotto.view.InputView
import Lotto.view.ResultView

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

    fun inputWinningNumber(): List<LottoNumber> {
        inputView.show(InputMessage.WINNING_LOTTO)
        return inputIO.inputWinningNumber()
    }

    fun inputBonusNumber(): LottoNumber {
        inputView.show(InputMessage.WINNING_LOTTO)
        return inputIO.inputBonusNumber()
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
