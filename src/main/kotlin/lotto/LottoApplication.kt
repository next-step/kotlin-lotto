package lotto

import lotto.domain.strategy.bonus.BonusManualGenerateStrategy
import lotto.domain.strategy.lotto.LottoAutoGenerateStrategy
import lotto.domain.LottoMachine
import lotto.domain.strategy.lotto.LottoManualGenerateStrategy
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val money = InputView.read()
    val lottoMachine = LottoMachine(
        money = money,
        lottoGenerateStrategy = LottoAutoGenerateStrategy(),
        winnerLottoGenerateStrategy = LottoManualGenerateStrategy(),
        bonusGenerateStrategy = BonusManualGenerateStrategy()
    )
    OutputView.printPurchaseTicketResult(lottoMachine.lottoTickets)
    OutputView.printWinnerTicket()
    val lottoSummary = lottoMachine.execute()
    OutputView.printSummary(lottoSummary)
}
