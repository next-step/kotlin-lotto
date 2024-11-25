package lotto

class ResultView {
    companion object {
        fun announceTooManyInputManualTicketCount(
            inputManualTicketCount: Int,
            affordableTicketCount: Int,
        ) = println(
            """
                |수동으로 구매할 로또 수가 구매할 수 있는 로또 수보다 많습니다. 
                |처음 부터 다시 시도해주세요!
                |(구매 가능한 로또 수=$affordableTicketCount, 수동으로 구매하려고 한 로또 수=$inputManualTicketCount)
            """.trimMargin(),
        )

        fun announceIssuedLotteryTickets(lotteryTickets: List<LottoTicket>) {
            println("${lotteryTickets.size}개를 구매했습니다.")
            for (ticket in lotteryTickets) {
                println(
                    ticket.numbers
                        .map(LottoNumber::value)
                        .joinToString(
                            prefix = "[",
                            postfix = "]",
                            separator = ", ",
                        ),
                )
            }
            println()
        }

        fun announceWinningStats(
            winningBoard: WinningBoard,
            lotteryTicketMachine: LotteryTicketMachine,
            winningResultsWithoutLose: List<WinningResult>,
        ) {
            println("당첨 통계")
            println("---------")
            announceWinningResultsWithEachCount(winningResultsWithoutLose, winningBoard)
            announceReturns(lotteryTicketMachine, winningBoard)
        }

        private fun announceWinningResultsWithEachCount(
            winningResultsWithoutLose: List<WinningResult>,
            winningBoard: WinningBoard,
        ) {
            winningResultsWithoutLose.forEach {
                println("${generateStatLabel(it)} - ${winningBoard.getWinningCount(it)}개")
            }
        }

        private fun generateStatLabel(it: WinningResult) =
            "${it.countOfMatch}개 일치${if (it == WinningResult.SECOND) ", 보너스 볼 일치" else " "}(${it.winnings.toInt()}원)"

        private const val BASE_RETURNS = 1

        private fun announceReturns(
            lotteryTicketMachine: LotteryTicketMachine,
            winningBoard: WinningBoard,
        ) {
            val returns = winningBoard.calculateRateOfReturn(lotteryTicketMachine.totalCost)
            val evaluationText: String = parseEvaluationText(BASE_RETURNS, returns)

            println("총 수익률은 ${returns.toDouble()}입니다.(기준이 ${BASE_RETURNS}이기 때문에 결과적으로 ${evaluationText}라는 의미임)")
        }

        private fun parseEvaluationText(
            baseReturns: Int,
            returns: Returns,
        ): String =
            if (baseReturns > returns.toDouble()) {
                "손해"
            } else if (baseReturns.toDouble() == returns.toDouble()) {
                "본전"
            } else {
                "이득"
            }
    }
}
