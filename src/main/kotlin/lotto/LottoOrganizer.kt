package lotto

import lotto.model.LottoGenerator
import lotto.model.LottoValidator
import lotto.view.InputView
import lotto.view.ResultView

enum class WinningMoneyList(
    val prize: Int
) {
    ZeroMatch(0),
    OneMatch(0),
    TwoMatch(0),
    ThreeMatch(5000),
    FourMatch(50000),
    FiveMatch(1500000),
    SixMatch(2000000000);

    companion object {
        fun getPrizePerMatch(matched: Int){
            when(matched){
                0 -> ZeroMatch
                1 -> OneMatch
                2 -> TwoMatch
                3 -> ThreeMatch
                4 -> FourMatch
                5 -> FiveMatch
                6 -> SixMatch
            }
        }
    }
}

class LottoOrganizer {

    fun start() {
        val tickets = LottoGenerator.generateTickets(InputView.getTicketCount())

        ResultView.renderTickets(tickets)

        ResultView.renderResults(
            ticketPrice = TICKET_PRICE,
            winningMoney = WINNING_MONEY_LIST,
            results = LottoValidator.validate(tickets, InputView.getWinningNumbers(TICKET_LENGTH), TICKET_LENGTH)
        )
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val TICKET_LENGTH = 6
        val TICKET_RANGE = 1..45
        val WINNING_MONEY_LIST = listOf(0, 0, 0, 5000, 50000, 1500000, 2000000000)
    }
}
