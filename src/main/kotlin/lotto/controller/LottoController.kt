package lotto.controller

import lotto.domain.Cash
import lotto.domain.LottoRewards
import lotto.domain.LottoStore
import lotto.domain.LottoUnusedTickets
import lotto.domain.LottoUsedTickets
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun buy() {
        val (inputCash, unusedTickets) = buyLotto()

        val (
            manualUsedTickets,
            autoUsedTickets
        ) = unusedTickets.use()
        OutputView.displayTickets(manualUsedTickets, autoUsedTickets)

        val rewards = (manualUsedTickets + autoUsedTickets).checkWin()
        OutputView.displayRewards(rewards)

        val profitRate = rewards.calculateYield(inputCash)
        OutputView.displayProfitRate(profitRate)
    }

    private fun buyLotto(): Pair<Cash, LottoUnusedTickets> {
        val inputCash = InputView.readCash().toCash()
        return inputCash to LottoStore.buyLotto(inputCash)
    }

    private fun LottoUnusedTickets.use(): Pair<LottoUsedTickets, LottoUsedTickets> {
        val ticketCountForManual = InputView.ticketCountForManual()
        val (ticketsForManual, ticketsForAuto) = this.divide(ticketCountForManual)
        val manualLottoRequests = InputView.ticketToManual(
            ticketsForManual.getTicketCount()
        )
        val manualUsedTickets = ticketsForManual.toManual(manualLottoRequests.requests)
        val autoUsedTickets = ticketsForAuto.toAuto()

        return manualUsedTickets to autoUsedTickets
    }

    private fun LottoUsedTickets.checkWin(): LottoRewards {
        val winTicket = InputView.readWinNumber()
            .toWinTicket()

        return this.evaluate(winTicket)
    }

    private fun LottoRewards.calculateYield(inputCash: Cash): Long {
        val rewardCash = this.exchange()
        return rewardCash.calculateYield(inputCash)
    }
}
