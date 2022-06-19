package camp.nextstep.lotto.ui.cli

import camp.nextstep.lotto.raffle.Winnings
import camp.nextstep.lotto.ticket.LottoTicket
import camp.nextstep.lotto.ui.LottoResult

object LottoResultWriter {

    fun write(result: LottoResult) {
        val emptyWinningsMap = Winnings.values().associateWith { listOf<LottoTicket>() }
        val winningsTicketMap = emptyWinningsMap + result.winningTickets.groupBy { it.winnings }

        println("당첨 통계")
        println("---------")
        for ((winnings, tickets) in winningsTicketMap) {
            val matchedBonus = if (winnings.matchedBonus) ", 보너스 볼 일치" else ""
            println("${winnings.matchedCount}개 일치$matchedBonus (${winnings.winnings}원) - ${tickets.size}개")
        }

        val earningRate = result.totalEarn / result.seed
        println("총 수익률은 ${earningRate}입니다. (${explainEarningRate(earningRate)})")
    }

    private fun explainEarningRate(earningRate: Int): String {
        return when {
            (earningRate > 1) -> "기준은 1이기 때문에 결과적으로 이익을 보았다는 의미"
            (earningRate < 1) -> "기준은 1이기 때문에 결과적으로 손해를 보았다는 의미"
            else -> "기준은 1이기 때문에 결과적으로 본전이라는 의미"
        }
    }
}
