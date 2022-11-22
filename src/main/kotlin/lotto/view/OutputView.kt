package lotto.view

import lotto.domain.LottoSummary
import lotto.domain.LottoTickets

object OutputView {
    private const val DELIMITER = ", "
    private const val INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."

    fun printPurchaseTicketResult(lottoTickets: LottoTickets) {
        println("${lottoTickets.tickets.size}개를 구매했습니다.")
        lottoTickets.tickets.map { lottoTicket ->
            println("[${lottoTicket.lottoNumbers.map { it.number }.joinToString(DELIMITER)}]")
        }
    }

    fun printWinnerTicket() {
        println(INPUT_MESSAGE)
    }

    fun printSummary(lottoSummary: LottoSummary) {
        println("당첨 통계")
        println("---------")
        lottoSummary.winners.forEach { winner ->
            println("${winner.lottoInfo.matchCount}개 일치 (${winner.lottoInfo.amount}원)- ${winner.count}개")
        }
        println("총 수익률은 ${lottoSummary.rateOfReturn}입니다.")
    }
}
