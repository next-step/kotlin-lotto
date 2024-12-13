package lotto.controller

import lotto.domain.AutoLottoIssuer
import lotto.domain.LottoNumberGenerator
import lotto.domain.LottoPurchaseCalculator
import lotto.domain.LottoTickets
import lotto.domain.LottoWinnerNumbers
import lotto.view.LottoPayoutView
import lotto.view.ManualLottoView
import lotto.view.PurchaseLottoView
import lotto.view.WinnerLottoNumberView

object LottoController {
    fun getMaxPurchaseLottoCountFromPayment(): Int {
        val amountPaid = PurchaseLottoView.inputPurchaseCost()
        return LottoPurchaseCalculator.getMaxPurchasedLottoTicketCount(amountPaid)
    }

    fun purchaseManualLotto(maxPurchaseLottoCount: Int): LottoTickets {
        val manualLottoCount = ManualLottoView.inputManualLottoCount(maxPurchaseLottoCount)
        return ManualLottoView.repeatInputManualLottoNumbers(manualLottoCount)
    }

    fun createAutoLotto(
        maxPurchaseLottoCount: Int,
        manualLottoTickets: LottoTickets,
    ): LottoTickets {
        val autoLottoCount = maxPurchaseLottoCount - manualLottoTickets.lottoTickets.size

        val autoLottoTickets =
            AutoLottoIssuer.issueAutoLottoTickets(autoLottoCount) {
                LottoNumberGenerator.generateAutoLottoNumbers()
            }

        PurchaseLottoView.displayPurchasedLottosView(
            manualLottoTickets = manualLottoTickets,
            autoLottoTickets = autoLottoTickets,
        )

        val combinedManualLottoAndAutoLotto = manualLottoTickets.lottoTickets.plus(autoLottoTickets.lottoTickets)

        return LottoTickets(combinedManualLottoAndAutoLotto)
    }

    fun createWinningLottoNumbers(): LottoWinnerNumbers {
        val inputLottoNumbers = WinnerLottoNumberView.inputWinningLottoNumbers()
        val inputBonusNumber = WinnerLottoNumberView.inputBonusNumber()

        return LottoWinnerNumbers(lottoNumbers = inputLottoNumbers, bonusNumber = inputBonusNumber)
    }

    fun resultPayout(
        lottoTickets: LottoTickets,
        lottoWinnerNumbers: LottoWinnerNumbers,
    ) {
        val purchasedLottoResults = lottoWinnerNumbers.resultLottoPayout(lottoTickets)
        return LottoPayoutView.displayWinningStatistics(purchasedLottoResults = purchasedLottoResults)
    }
}
