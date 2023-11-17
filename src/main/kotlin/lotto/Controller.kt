package lotto

import lotto.model.LottoTicket
import lotto.model.LottoWinners
import lotto.model.PurchaseGames
import lotto.model.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val totalPurchaseCount: Int = InputView.purchaseAmount(PurchaseGames.priceOfGame())
    val purchaseAmount: PurchaseGames = InputView.purchaseManual(totalPurchaseCount)
    val manualTicket: LottoTicket = purchaseAmount.manual()
    val autoTicket: LottoTicket = purchaseAmount.auto()
    OutputView.presentPurchaseInfo(manualTicket, autoTicket)
    val totalTicket: LottoTicket = autoTicket + manualTicket
    OutputView.presetRound(totalTicket)
    val winningNumbers: WinningNumbers = InputView.selectWinningNumbers()
    val lottoWinners: LottoWinners = totalTicket.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(lottoWinners)
}
