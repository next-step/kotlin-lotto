package lotto.presentation

import lotto.domain.LottoMatchType
import lotto.domain.LottoRewardCalculator
import lotto.domain.LottoTickets
import lotto.domain.LottoWinningNumber

class OutboundView {

    fun printLottoTickets(lottoTickets: LottoTickets) {
        println("${lottoTickets.getLottoTickets().size} 개를 구매했습니다.")

        lottoTickets.getLottoTickets()
            .forEach { ticket ->
                println(ticket.numbers.joinToString(prefix = "[", postfix = "]"))
            }
    }

    fun printLottoMatchCount(lottoTickets: LottoTickets, winningNumber: LottoWinningNumber) {
        println("\n당첨 동계")
        println("---------")

        LottoMatchType.values()
            .forEach {
                if (it.isBonus) {
                    println(
                        "${it.matchCount}개 일치, 보너스 볼 일치(${it.reward}원) - " +
                            "${lottoTickets.getMatchCount(it, winningNumber)}개"
                    )
                } else {
                    println(
                        "${it.matchCount}개 일치 (${it.reward}원) - " +
                            "${lottoTickets.getMatchCount(it, winningNumber)}개"
                    )
                }
            }
    }

    fun printRewardRate(lottoRewardCalculator: LottoRewardCalculator, purchaseAmount: Int, lottoTicketPrice: Int) {
        val profit = String.format("%.02f", lottoRewardCalculator.calculateRewardRate(purchaseAmount, lottoTicketPrice))
        println("총 수익률은 ${profit}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
