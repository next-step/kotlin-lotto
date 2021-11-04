package lotto

import lotto.domain.LottoMoney
import lotto.domain.LottoNumbers
import lotto.domain.LottoStatistics
import lotto.domain.RandomNumberGenerator
import lotto.ui.ConsoleInputView
import lotto.ui.ConsoleOutputView
import lotto.ui.dto.LottoNumbersDto
import lotto.ui.dto.LottoStatisticsDto

object LottoController {

    fun buyTickets(): List<LottoNumbers> {
        val ticketCounts = LottoMoney(ConsoleInputView.getBuyAmount()).calculateCount()
        ConsoleOutputView.printTicketCount(ticketCounts.value)

        val tickets = mutableListOf<LottoNumbers>()
        while (ticketCounts.isTicketRemain()) {
            val newTicket = RandomNumberGenerator.nextSix()
            tickets.add(newTicket)
            ticketCounts.useTicket()
            ConsoleOutputView.printLottoTickets(LottoNumbersDto(newTicket))
        }
        return tickets
    }

    fun getWinning(): LottoNumbers {
        return LottoNumbers(ConsoleInputView.getWinning())
    }

    fun getStatistics(tickets: List<LottoNumbers>, winnerNumbers: LottoNumbers) {
        val statistics = LottoStatistics.from(tickets, winnerNumbers)
        val result = statistics.countByRanking
        val revenue = statistics.revenue
        ConsoleOutputView.printStatistics(LottoStatisticsDto(result, revenue))
    }
}
