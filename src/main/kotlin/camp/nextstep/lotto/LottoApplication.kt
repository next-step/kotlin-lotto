package camp.nextstep.lotto

import camp.nextstep.lotto.interfaces.LottoResult
import camp.nextstep.lotto.interfaces.cli.GamblerReader
import camp.nextstep.lotto.interfaces.cli.GamblerWriter
import camp.nextstep.lotto.interfaces.cli.LottoResultWriter
import camp.nextstep.lotto.interfaces.cli.WinnerNumbersReader
import camp.nextstep.lotto.number.LottoNumbers
import camp.nextstep.lotto.raffle.LottoResultMatcher
import camp.nextstep.lotto.raffle.Winnings
import camp.nextstep.lotto.ticket.LottoStore
import camp.nextstep.lotto.ticket.LottoTicketMachine

fun main() {
    val lottoTicketPrice = 1_000
    val lottoTicketMachine = LottoTicketMachine()
    val lottoStore = LottoStore(lottoTicketPrice, lottoTicketMachine)

    val gambler = GamblerReader.read()
    val seedMoney = gambler.balance

    gambler.exchangeAll(lottoStore)

    GamblerWriter.write(gambler)

    val winnerNumbers = WinnerNumbersReader.read(LottoNumbers.LOTTO_NUMBERS)
    val winningsMap = LottoResultMatcher
        .ticketsByMatchedCount(gambler.tickets, winnerNumbers)
        .filterKeys { Winnings.isWinningCount(it) }
        .map { (matchedCount, tickets) -> Winnings.of(matchedCount) to tickets.size }
        .toMap()
    val totalEarning = winningsMap.map { it.key.winnings to it.value }.sumOf { it.first * it.second }
    val lottoResult = LottoResult(winningsMap, seedMoney, totalEarning)

    LottoResultWriter.write(lottoResult)
}
