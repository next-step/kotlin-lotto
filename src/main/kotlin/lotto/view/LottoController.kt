package lotto.view

import lotto.domain.LottoTicketIssuer
import lotto.domain.LottoWinnerNumbers
import lotto.domain.PurchasedLottoTickets
import lotto.domain.generateLottoNumbers

object LottoController {
    fun purchaseLotto(): PurchasedLottoTickets {
        val amountPaid = PurchaseLottoView.inputPurchaseCost()

        val purchasedLottoTickets =
            LottoTicketIssuer.issueTickets(amountPaid = amountPaid, generateLottoNumbers = { generateLottoNumbers() })

        PurchaseLottoResultView.displayPurchaseLottoResults(purchasedLottoTickets = purchasedLottoTickets)

        return purchasedLottoTickets
    }

    fun createWinningLottoNumbers(): LottoWinnerNumbers {
        return LottoWinnerNumbers(winnerNumbers = WinnerLottoNumberView.inputWinningLottoNumbers())
    }

    fun resultPayout(
        purchasedLottoTickets: PurchasedLottoTickets,
        lottoWinnerNumbers: LottoWinnerNumbers,
    ) {
        val purchasedLottoResults = lottoWinnerNumbers.resultLottoPayout(purchasedLottoTickets)
        return LottoPayoutView.displayWinningStatistics(purchasedLottoResults = purchasedLottoResults)
    }
}
