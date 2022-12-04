package lotto.view

import lotto.domain.LottoResultSummary
import lotto.domain.LottoTickets

object OutputView {
    private const val DELIMITER = ", "
    private const val INPUT_MESSAGE = "지난 주 당첨 번호와 보너스 볼을 입력해 주세요."

    fun printPurchaseTicketResult(lottoTickets: LottoTickets) {
        println("${lottoTickets.tickets.size}개를 구매했습니다.")
        lottoTickets.tickets.map { lottoTicket ->
            println("[${lottoTicket.lottoNumbers.map { it.number }.joinToString(DELIMITER)}]")
        }
    }

    fun printWinnerTicket() {
        println(INPUT_MESSAGE)
    }

    fun printSummary(lottoResultSummary: LottoResultSummary) {
        println("당첨 통계")
        println("---------")
        lottoResultSummary.winners.forEach { winner ->
            print("${winner.matchResult.matchCount}개 일치 ")
            if (winner.matchResult.isBonusBallMatched) print(", 보너스 볼 일치")
            println("(${winner.matchResult.amount}원)- ${winner.count}개")
        }
        println("총 수익률은 ${lottoResultSummary.rateOfReturn}입니다.")
    }
}
