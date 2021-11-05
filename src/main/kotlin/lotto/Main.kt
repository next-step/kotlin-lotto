package lotto

import lotto.domain.LottoMoney
import lotto.domain.LottoNumbers
import lotto.domain.LottoStatistics
import lotto.domain.LottoTickets
import lotto.domain.LottoTicketsFactory
import lotto.ui.ConsoleInputView
import lotto.ui.ConsoleOutputView
import lotto.ui.dto.LottoStatisticsDto
import lotto.ui.dto.LottoTicketsDto

fun main() {
    val tickets = buyTickets()
    val winning = getWinning()
    printResult(tickets, winning)
}

private fun buyTickets(): LottoTickets {
    val ticketCounts = LottoMoney(ConsoleInputView.getBuyAmount()).calculateCount()
    ConsoleOutputView.printTicketCount(ticketCounts.value)

    val tickets = LottoTicketsFactory.create(ticketCounts)
    ConsoleOutputView.printLottoTickets(LottoTicketsDto(tickets))
    return tickets
}

private fun getWinning(): LottoNumbers {
    return LottoNumbers(ConsoleInputView.getWinning())
}

private fun printResult(tickets: LottoTickets, winning: LottoNumbers) {
    val statistics = LottoStatistics.from(tickets, winning)
    val result = statistics.countByRanking
    val revenue = statistics.revenue
    ConsoleOutputView.printStatistics(LottoStatisticsDto(result, revenue))
}
