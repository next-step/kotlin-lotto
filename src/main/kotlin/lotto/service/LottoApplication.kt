package lotto.service

import lotto.domain.LottoPrizeManager
import lotto.domain.LottoTicket
import lotto.domain.Money
import lotto.domain.TicketSeller
import lotto.util.InputModule
import lotto.util.OutPutModule
import lotto.util.RandomGenerate
import lotto.view.BuyLottoInputView
import lotto.view.BuyLottoOutputView

class LottoApplication(
    private val inputModule: InputModule,
    private val outPutModule: OutPutModule,
    randomGenerate: RandomGenerate
) {
    private val ticketSeller = TicketSeller(randomGenerate)

    fun run() {
        val buyLottoOutputView = BuyLottoOutputView(outPutModule)
        val buyLottoInputView = BuyLottoInputView(inputModule, outPutModule)

        val userMoney = buyLottoInputView.readUserMoneyInput()
        val passiveLottoTickets = buyLottoInputView.readPassiveTickets()
        val boughtLottoTickets = ticketSeller.buyPossibleLottoTicket(userMoney)

        buyLottoOutputView.showAllBoughtTickets(boughtLottoTickets, passiveLottoTickets)

        val winningLottoTicketNumbers = buyLottoInputView.readWinningLottoNumbers()
        val totalBoughtTickets: MutableList<LottoTicket> = mutableListOf()
        totalBoughtTickets.addAll(boughtLottoTickets)
        totalBoughtTickets.addAll(passiveLottoTickets)

        buyLottoOutputView.showTotalWinningInformation(
            Money(totalBoughtTickets.size * ticketSeller.ticketPrice.value),
            lottoPrizeManager.getWinningStats(
                totalBoughtTickets,
                winningLottoTicketNumbers
            )
        )
    }

    companion object {
        private val lottoPrizeManager = LottoPrizeManager()
    }
}
