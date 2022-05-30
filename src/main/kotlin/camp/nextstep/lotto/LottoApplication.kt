package camp.nextstep.lotto

import camp.nextstep.lotto.raffle.LottoResultMatcher
import camp.nextstep.lotto.ticket.LottoStore
import camp.nextstep.lotto.ticket.LottoTicketMachine
import camp.nextstep.lotto.ui.LottoResult
import camp.nextstep.lotto.ui.cli.BonusNumberReader
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

    gambler.exchangeAll(lottoStore)

    GamblerWriter.write(gambler)

    val winnerNumbers = WinnerNumbersReader.read()
    val bonusNumber = BonusNumberReader.read()
    val winningTickets = LottoResultMatcher.winningTickets(gambler.tickets, winnerNumbers, bonusNumber)
    val totalEarning = winningTickets.sumOf { it.winnings.winnings }
    val lottoResult = LottoResult(winningTickets, seedMoney, totalEarning)

    LottoResultWriter.write(lottoResult)
}
