package lotto.controller

import lotto.domain.AutoLottoGenerator
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.LottoStatisticService
import lotto.domain.LottoStore
import lotto.domain.ManualLottoCount
import lotto.domain.PurchaseAmount
import lotto.domain.dto.ProfitRateRequest
import lotto.domain.dto.PurchaseLottoRequest
import lotto.domain.dto.StatisticsRequest
import lotto.view.InputIO
import lotto.view.InputMessage
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputIO = InputIO()
    private val inputView = InputView()
    private val lottoStatisticService = LottoStatisticService()
    private val lottoStore = LottoStore(AutoLottoGenerator())
    private val resultView = ResultView()

    fun inputPurchaseAmount(): PurchaseAmount {
        inputView.show(InputMessage.PURCHASE_AMOUNT)
        return inputIO.inputPurchaseAmount()
    }

    fun inputManualLottoCount(): ManualLottoCount {
        inputView.show(InputMessage.MANUAL_LOTTO_COUNT)
        return inputIO.inputManualLottoCount()
    }

    fun createPurchaseLottoRequest(purchaseAmount: PurchaseAmount, manualLottoCount: ManualLottoCount): PurchaseLottoRequest {
        return try {
            PurchaseLottoRequest(purchaseAmount, manualLottoCount)
        } catch (e: IllegalArgumentException) {
            this.createPurchaseLottoRequest(purchaseAmount, this.inputManualLottoCount())
        }
    }

    fun purchaseLottoTickets(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoTickets = lottoStore.purchaseLottoTickets(purchaseAmount)
        resultView.showLottoTicketQuantity(lottoTickets.size)
        resultView.showLottoTickets(lottoTickets)
        return lottoTickets
    }

    fun inputWinningNumber(): List<LottoNumber> {
        inputView.show(InputMessage.WINNING_NUMBERS)
        return inputIO.inputWinningNumber()
    }

    fun inputBonusNumber(): LottoNumber {
        inputView.show(InputMessage.BONUS_NUMBER)
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
