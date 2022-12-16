package lotto

import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun buy() {
        val inputCash = InputView.readCash()

        val (restCash, unusedTickets) = LottoStore.buyLotto(inputCash)
        val ticketCount = unusedTickets.getTicketCount()
        OutputView.displayTicketCount(ticketCount)

        val (usedTickets, _) = unusedTickets.toAuto(ticketCount)
        OutputView.displayTickets(usedTickets)

        val winTicket = InputView.readWinNumber()

        val rewards = usedTickets.evaluate(winTicket)
        OutputView.displayRewards(rewards)

        val rewardCash = rewards.exchange()
        val profitRate = rewardCash.divide(inputCash.subtract(restCash))
        OutputView.displayProfitRate(profitRate)
    }
}
