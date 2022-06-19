package camp.nextstep.lotto

import camp.nextstep.lotto.raffle.LottoResultMatcher
import camp.nextstep.lotto.ticket.LottoStore
import camp.nextstep.lotto.ticket.LottoTicketMachine
import camp.nextstep.lotto.ui.LottoResult
import camp.nextstep.lotto.ui.cli.GamblerNumbersReader
import camp.nextstep.lotto.ui.cli.GamblerReader
import camp.nextstep.lotto.ui.cli.GamblerWriter
import camp.nextstep.lotto.ui.cli.LottoResultWriter
import camp.nextstep.lotto.ui.cli.WinnerNumbersReader

fun main() {
    val lottoTicketPrice = 1_000
    val lottoTicketMachine = LottoTicketMachine()
    val lottoStore = LottoStore(lottoTicketPrice, lottoTicketMachine)

    val gambler = GamblerReader.read()
    val seedMoney = gambler.balance

    val gamblerNumbers = GamblerNumbersReader.read()

    gambler.exchange(lottoStore, gamblerNumbers.numbers)
    gambler.exchangeAll(lottoStore)

    GamblerWriter.write(gambler)

    val winnerNumbers = WinnerNumbersReader.read()
    val winningTickets = LottoResultMatcher.winningTickets(gambler.tickets, winnerNumbers)
    val totalEarning = winningTickets.sumOf { it.winnings.winnings }
    val lottoResult = LottoResult(winningTickets, seedMoney, totalEarning)

    LottoResultWriter.write(lottoResult)
}
