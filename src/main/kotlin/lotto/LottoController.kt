package lotto

import lotto.view.InputViewImpl
import lotto.view.OutputViewImpl

class LottoController {

    fun buy() {
        val inputCash = InputViewImpl.readCash()

        val (restCash, unusedTickets) = inputCash.buyTickets()
        val ticketCount = unusedTickets.getTicketCount()
        OutputViewImpl.displayTicketCount(ticketCount)

        val (usedTickets, _) = unusedTickets.toAuto(ticketCount)
        OutputViewImpl.displayTickets(usedTickets)

        val winTicket = InputViewImpl.readWinNumber()

        val rewards = usedTickets.evaluate(winTicket)
        OutputViewImpl.displayRewards(rewards)

        val rewardCash = rewards.exchange()
        val profitRate = rewardCash.divide(inputCash.subtract(restCash))
        OutputViewImpl.displayProfitRate(profitRate)
    }
}
