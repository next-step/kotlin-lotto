package lotto

import lotto.domain.LottoMachine
import lotto.domain.input.ConsoleInput
import lotto.domain.strategy.bonus.BonusManualGenerateStrategy
import lotto.domain.strategy.lotto.LottoAutoGenerateStrategy
import lotto.domain.strategy.lotto.LottoManualGenerateStrategy
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = InputView.readMoney()
    val manualTicketCount = InputView.readManualTicketCount()
    val lottoMachine = LottoMachine(
        money = money,
        manualTicketCount = manualTicketCount,
        lottoGenerateStrategies = listOf(LottoAutoGenerateStrategy(), LottoManualGenerateStrategy(ConsoleInput())),
        winnerLottoGenerateStrategy = LottoManualGenerateStrategy(ConsoleInput()),
        bonusGenerateStrategy = BonusManualGenerateStrategy(ConsoleInput())
    )
    OutputView.printPurchaseTicketResult(lottoMachine.lottoTickets)
    OutputView.printWinnerTicket()
    val lottoSummary = lottoMachine.execute()
    OutputView.printSummary(lottoSummary)
}
