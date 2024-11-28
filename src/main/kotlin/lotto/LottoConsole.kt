package lotto

fun main() {
    val inputBalance = ConsoleInput.inputBalance()

    val lotteryTicketMachine = LotteryTicketMachine(balance = inputBalance)

    val affordableTicketCount = lotteryTicketMachine.affordableTickets()
    val inputManualTicketCount = ConsoleInput.inputManualTicketCount()
    if (inputManualTicketCount > affordableTicketCount) {
        ResultView.announceTooManyInputManualTicketCount(inputManualTicketCount, affordableTicketCount)
        return
    }

    val manualLotteryTickets =
        if (inputManualTicketCount > 0) {
            issueManualLotteryTickets(inputManualTicketCount, lotteryTicketMachine)
        } else {
            emptyList()
        }
    val automaticLotteryTickets = generateSequence { lotteryTicketMachine.issueTicket() }.toList()
    val lotteryTickets = manualLotteryTickets + automaticLotteryTickets

    ResultView.announceIssuedLotteryTickets(lotteryTickets)

    val inputDefaultWinningTicket = ConsoleInput.inputDefaultWinningTicket()
    val inputBonusNumber = ConsoleInput.inputBonusNumber()
    val winningTicket =
        WinningTicket(
            defaultTicket = inputDefaultWinningTicket,
            bonusNumber = inputBonusNumber,
        )
    println()

    val checkedResults = winningTicket.checkTicketAll(lotteryTickets)

    val winningBoard = WinningBoard(checkedResults)
    val winningResultsWithWinningsSorted =
        WinningResult.entries.filterNot { it == WinningResult.LOSE }.sortedBy { it.winnings }

    println("당첨 통계")
    println("---------")
    winningResultsWithWinningsSorted.forEach {
        ResultView.announceWinningResultsWithEachCount(it, winningBoard.getWinningCount(it))
    }
    val rateOfReturn =
        winningBoard.calculateRateOfReturn(totalCost = lotteryTicketMachine.totalCost)
    ResultView.announceRateOfReturn(rateOfReturn)
}

private fun issueManualLotteryTickets(
    inputManualTicketCount: Long,
    lotteryTicketMachine: LotteryTicketMachine,
): List<LottoTicket> {
    println("수동으로 구매할 번호를 입력해 주세요.")
    return (1..inputManualTicketCount).mapNotNull {
        lotteryTicketMachine.issueTicket(ConsoleInput.inputManualLottoNumbers())
    }
}
