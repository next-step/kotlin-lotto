package lotto.view

import lotto.domain.WinningAmount
import lotto.domain.WinningAmount.FIFTH
import lotto.domain.WinningAmount.FIRST
import lotto.domain.WinningAmount.FOURTH
import lotto.domain.WinningAmount.SECOND
import lotto.domain.WinningAmount.THIRD
import lotto.domain.lottoticket.LottoTicket
import lotto.domain.lottoticket.LottoTickets
import java.math.BigDecimal

class OutputView {
    fun printTotalTicketCount(lottoTickets: LottoTickets) {
        println("수동으로 ${lottoTickets.manualCount}장, 자동으로 ${lottoTickets.autoCount}개를 구매했습니다.")
        lottoTickets.autoTickets.forEach { printLotto(lottoTicket = it) }
        println()
    }

    private fun printLotto(lottoTicket: LottoTicket) {
        println(
            lottoTicket.lottoNumbers
                .values
                .map { it.value }
        )
    }

    fun printWinningResult(results: Map<WinningAmount, Int>) {
        println("당첨 통계")
        println("---------")
        println("${FIFTH.matchCount}개 일치 (${FIFTH.amount}원)- ${results[FIFTH]}개")
        println("${FOURTH.matchCount}개 일치 (${FOURTH.amount}원)- ${results[FOURTH]}개")
        println("${THIRD.matchCount}개 일치 (${THIRD.amount}원)- ${results[THIRD]}개")
        println("${SECOND.matchCount}개 일치, 보너스 볼 일치 (${SECOND.amount}원)- ${results[SECOND]}개")
        println("${FIRST.matchCount}개 일치 (${FIRST.amount}원)- ${results[FIRST]}개")
    }

    fun printYield(yield: BigDecimal) {
        println("총 수익률은 ${`yield`}입니다.")
    }
}
