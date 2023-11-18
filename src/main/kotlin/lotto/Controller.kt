package lotto

import lotto.model.LottoPurchaseInfo
import lotto.model.LottoTicket
import lotto.model.LottoWinners
import lotto.model.WinningNumbers
import lotto.model.strategy.LottoNumberRandomStrategy
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val totalPurchaseCount: Int = InputView.purchaseAmount(LottoPurchaseInfo.priceOfGame())
    val purchaseAmount: LottoPurchaseInfo = InputView.purchaseManual(totalPurchaseCount)
    val manualTicket: LottoTicket = purchaseAmount.lottoTicketManual()
    val autoTicket: LottoTicket = purchaseAmount.lottoTicketAuto(LottoNumberRandomStrategy)
    OutputView.presentPurchaseInfo(manualTicket, autoTicket)
    val totalTicket: LottoTicket = autoTicket + manualTicket
    OutputView.presetRound(totalTicket)
    val winningNumbers: WinningNumbers = InputView.selectWinningNumbers()
    val lottoWinners: LottoWinners = totalTicket.winnerAggregate(winningNumbers)
    OutputView.presentPrizes(lottoWinners)
}
