package lotto

fun main() {
    val inputBalance = ConsoleInput.inputBalance()

    val lotteryTicketMachine = LotteryTicketMachine(balance = inputBalance)
    val lotteryTickets = generateSequence { lotteryTicketMachine.issueTicket() }.toList()

    ResultView.announceIssuedLotteryTickets(lotteryTickets)

    val inputWinningNumbers = ConsoleInput.inputWinningNumbers()
    println()

    val lotteryWinningChecker = LotteryWinningChecker(winningTicket = LottoTicket(inputWinningNumbers))
    val checkedResults = lotteryTickets.map { lotteryWinningChecker.checkTicket(it) }

    val winningBoard = WinningBoard(checkedResults)
    val winningResultsWithWinningsSorted = WinningResult.entries.filterNot { it == WinningResult.LOSE }.sortedBy { it.winnings }
    ResultView.announceWinningStats(winningBoard, lotteryTicketMachine, winningResultsWithWinningsSorted)
}
