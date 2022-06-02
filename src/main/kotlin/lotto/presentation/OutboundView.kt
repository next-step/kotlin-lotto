package lotto.presentation

import lotto.domain.LottoMatchType
import lotto.domain.LottoRewardCalculator
import lotto.domain.LottoTickets
import lotto.domain.LottoWinningNumber

class OutboundView {

    fun printLottoTickets(lottoTickets: LottoTickets) {
        println("${lottoTickets.getLottoTickets().size} 개를 구매했습니다.")

        lottoTickets.getLottoTickets()
            .forEach { println(it.numbers.joinToString(prefix = "[", postfix = "]")) }
    }

    fun printLottoMatchCount(lottoTickets: LottoTickets, winningNumber: LottoWinningNumber) {
        println("\n당첨 동계")
        println("---------")

        LottoMatchType.values()
            .forEach { printMatchCountResult(it, lottoTickets, winningNumber) }
    }

    fun printRewardRate(lottoRewardCalculator: LottoRewardCalculator, purchaseAmount: Int, lottoTicketPrice: Int) {
        val profit = String.format("%.02f", lottoRewardCalculator.calculateRewardRate(purchaseAmount, lottoTicketPrice))
        println("총 수익률은 ${profit}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun printMatchCountResult(
        lottoMatchType: LottoMatchType,
        lottoTickets: LottoTickets,
        winningNumber: LottoWinningNumber
    ) {
        if (lottoMatchType.isBonus) {
            println(
                "${lottoMatchType.matchCount}개 일치, 보너스 볼 일치(${lottoMatchType.reward}원) - " +
                    "${lottoTickets.getMatchCount(lottoMatchType, winningNumber)}개"
            )
            return
        }

        println(
            "${lottoMatchType.matchCount}개 일치 (${lottoMatchType.reward}원) - " +
                "${lottoTickets.getMatchCount(lottoMatchType, winningNumber)}개"
        )
    }
}
