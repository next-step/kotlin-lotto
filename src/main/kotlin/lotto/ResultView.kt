package lotto

class ResultView {
    companion object {
        fun announceTooManyInputManualTicketCount(
            inputManualTicketCount: Long,
            affordableTicketCount: Long,
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

        fun announceWinningResultsWithEachCount(
            winningResult: WinningResult,
            winningCount: Int,
        ) {
            println("${generateStatLabel(winningResult)} - ${winningCount}개")
        }

        private fun generateStatLabel(winningResult: WinningResult) =
            "${winningResult.countOfMatch}개 일치${generateBlankOrBonusBallText(winningResult)}(${winningResult.winnings.toLong()}원)"

        private fun generateBlankOrBonusBallText(winningResult: WinningResult) =
            if (winningResult == WinningResult.SECOND) ", 보너스 볼 일치" else " "

        fun announceRateOfReturn(rateOfReturn: RateOfReturn) {
            val evaluationText: String = parseEvaluationText(rateOfReturn)
            println("총 수익률은 ${rateOfReturn.toDouble()}입니다.(기준이 ${RateOfReturn.BASE_RATE_OF_RETURN}이기 때문에 결과적으로 ${evaluationText}라는 의미임)")
        }

        private fun parseEvaluationText(rateOfReturn: RateOfReturn): String =
            if (RateOfReturn.BASE_RATE_OF_RETURN > rateOfReturn.toDouble()) {
                "손해"
            } else if (RateOfReturn.BASE_RATE_OF_RETURN.toDouble() == rateOfReturn.toDouble()) {
                "본전"
            } else {
                "이득"
            }
    }
}
