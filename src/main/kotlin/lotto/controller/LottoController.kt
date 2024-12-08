package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoTicketIssuer
import lotto.domain.LottoWinnerNumbers
import lotto.domain.PurchasedLottoTickets
import lotto.domain.generateLottoNumbers
import lotto.view.LottoPayoutView
import lotto.view.PurchaseLottoResultView
import lotto.view.PurchaseLottoView
import lotto.view.WinnerLottoNumberView

object LottoController {
    fun purchaseLotto(): PurchasedLottoTickets {
        val amountPaid = PurchaseLottoView.inputPurchaseCost()

        val purchasedLottoTickets =
            LottoTicketIssuer.issueTickets(amountPaid = amountPaid, generateLottoNumbers = { generateLottoNumbers() })

        PurchaseLottoResultView.displayPurchaseLottoResults(purchasedLottoTickets = purchasedLottoTickets)

        return purchasedLottoTickets
    }

    fun createWinningLottoNumbers(): LottoWinnerNumbers {
        val inputLottoNumbers = WinnerLottoNumberView.inputWinningLottoNumbers()
        val lottoNumbers = LottoNumbers(inputLottoNumbers.map { LottoNumber.of(it) }.toSet())
        val inputBonusNumber = WinnerLottoNumberView.inputBonusNumber()
        return LottoWinnerNumbers(lottoNumbers = lottoNumbers, bonusNumber = LottoNumber.of(inputBonusNumber))
    }

    fun resultPayout(
        purchasedLottoTickets: PurchasedLottoTickets,
        lottoWinnerNumbers: LottoWinnerNumbers,
    ) {
        val purchasedLottoResults = lottoWinnerNumbers.resultLottoPayout(purchasedLottoTickets)
        return LottoPayoutView.displayWinningStatistics(purchasedLottoResults = purchasedLottoResults)
    }
}
