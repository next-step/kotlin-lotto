package lotto

fun main() {
    val inputBalance = ConsoleInput.inputBalance()

    val lotteryTicketMachine = LotteryTicketMachine(balance = inputBalance)
    val lotteryTickets = generateSequence { lotteryTicketMachine.issueTicket() }.toList()

    ResultView.announceIssuedLotteryTickets(lotteryTickets)

    val inputDefaultWinningTicket = ConsoleInput.inputDefaultWinningTicket()
    val inputBonusNumber = ConsoleInput.inputBonusNumber()
    val winningTicket =
        WinningTicket(
            defaultTicket = inputDefaultWinningTicket,
            bonusNumber = inputBonusNumber,
        )
    println()

    val checkedResults = lotteryTickets.map { winningTicket.checkTicket(it) }

    val winningBoard = WinningBoard(checkedResults)
    val winningResultsWithWinningsSorted =
        WinningResult.entries.filterNot { it == WinningResult.LOSE }.sortedBy { it.winnings }
    ResultView.announceWinningStats(
        winningBoard,
        lotteryTicketMachine,
        winningResultsWithWinningsSorted,
    )
}
