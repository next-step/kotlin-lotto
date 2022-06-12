package lotto.service

import lotto.domain.LottoPrizeManager
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
    private val ticketSeller = TicketSeller(lottoTicketPrice, randomGenerate)

    fun run() {
        val buyLottoOutputView = BuyLottoOutputView(outPutModule)
        val buyLottoInputView = BuyLottoInputView(inputModule, outPutModule)

        val userMoney = buyLottoInputView.readUserMoneyInput()
        val passiveLottoTickets = buyLottoInputView.readPassiveTickets()
        val boughtLottoTickets = ticketSeller.buyPossibleLottoTicket(userMoney)

        buyLottoOutputView.showAllBoughtTickets(boughtLottoTickets)

        val winningLottoTicketNumbers = buyLottoInputView.readWinningLottoNumbers()

        buyLottoOutputView.showTotalWinningInformation(
            Money(boughtLottoTickets.size * lottoTicketPrice.value),
            lottoPrizeManager.getWinningStats(
                boughtLottoTickets,
                winningLottoTicketNumbers
            )
        )
    }

    companion object {
        private val lottoTicketPrice = Money(1000)
        private val lottoPrizeManager = LottoPrizeManager()
    }
}
