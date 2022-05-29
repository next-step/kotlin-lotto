package lotto.presentation

import lotto.domain.LottoRewardCalculator
import lotto.domain.LottoWinningNumber
import lotto.domain.collection.LottoTickets
import lotto.domain.type.LottoMatchType

class OutboundView {

    fun printLottoTickets(lottoTickets: LottoTickets) {
        println("${lottoTickets.getLottoTickets().size} 개를 구매했습니다.")

        lottoTickets.getLottoTickets()
            .forEach { ticket ->
                println(ticket.numbers.joinToString(prefix = "[", postfix = "]\n"))
            }
    }

    fun printLottoMatchCount(lottoTickets: LottoTickets, winningNumber: LottoWinningNumber) {
        println("\n당첨 동계")
        println("---------")

        LottoMatchType.values().forEach {
            println(
                "${it.matchCount}개 일치 (${it.reward}원) - " +
                    "${lottoTickets.getMatchCount(it.matchCount, winningNumber.numbers)}개"
            )
        }
    }

    fun printRewardRate(lottoRewardCalculator: LottoRewardCalculator, purchaseAmount: Int, lottoTicketPrice: Int) {
        val profit = String.format("%.02f", lottoRewardCalculator.getRewardRate(purchaseAmount, lottoTicketPrice))
        println("총 수익률은 ${profit}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
