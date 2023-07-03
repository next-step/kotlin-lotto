package lotto.controller

import lotto.domain.AutoLottoGenerator
import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoStatisticService
import lotto.domain.LottoStore
import lotto.domain.ManualLottoCount
import lotto.domain.ManualLottoTickets
import lotto.domain.PurchaseAmount
import lotto.domain.WinningLotto
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

    fun inputManualLottoNumbers(manualLottoCount: ManualLottoCount): ManualLottoTickets {
        inputView.show(InputMessage.MANUAL_LOTTO_NUMBERS)
        return inputIO.inputManualLottoNumbers(manualLottoCount)
    }

    fun createPurchaseLottoRequest(purchaseAmount: PurchaseAmount, manualLottoCount: ManualLottoCount, manualLottoTickets: ManualLottoTickets): PurchaseLottoRequest {
        return try {
            PurchaseLottoRequest(purchaseAmount, manualLottoCount, manualLottoTickets)
        } catch (e: IllegalArgumentException) {
            this.createPurchaseLottoRequest(purchaseAmount, this.inputManualLottoCount(), manualLottoTickets)
        }
    }

    fun purchaseLottoTickets(purchaseLottoRequest: PurchaseLottoRequest): List<Lotto> {
        val purchaseLottoResponse = lottoStore.purchaseLottoTickets(purchaseLottoRequest)
        resultView.showLottoTicketQuantity(purchaseLottoResponse.autoLottoCount, purchaseLottoResponse.manualLottoCount)
        resultView.showLottoTickets(purchaseLottoResponse.lottoTickets)
        return purchaseLottoResponse.lottoTickets
    }

    fun inputWinningLotto(): WinningLotto {
        inputView.show(InputMessage.WINNING_NUMBERS)
        val winningLottoNumber = inputIO.inputLottoNumber()

        inputView.show(InputMessage.BONUS_NUMBER)
        val bonusNumber = inputIO.inputBonusNumber()

        return WinningLotto(winningLottoNumber, bonusNumber)
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
