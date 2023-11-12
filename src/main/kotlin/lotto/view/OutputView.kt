package lotto.view

import lotto.controller.EndLottoResponse
import lotto.controller.PurchaseResponse
import lotto.domain.EarningRate
import lotto.domain.LottoRank
import lotto.domain.LottoRankCounts
import lotto.domain.LottoTicket

object OutputView {
    private const val RESULT_MSG = "당첨 통계"
    private const val DIVIDE_LINE = "---------"
    private const val MATCHED_COUNT_MSG = "%d개 일치 (%d원)- %d개"
    private const val BONUS_MATCHED_COUNT_MSG_ = "%d개 일치, 보너스 볼 일치(%d원)- %d개"
    private const val PURCHASE_COUNT_MSG = "%d개를 구매했습니다"
    private const val EARNING_RATE_MSG = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)"

    fun drawPurchaseOutput(response: PurchaseResponse) {
        val tickets = response.tickets
        drawPurchaseCount(tickets.count)
        drawTickets(tickets.tickets)
    }

    fun drawEarningRateOutput(response: EndLottoResponse) {
        val result = response.result
        println()
        println(RESULT_MSG)
        println(DIVIDE_LINE)
        drawMatchedCount(result.rankCounts)
        drawEarningRate(result.earningRate)
    }

    private fun drawPurchaseCount(count: Int) {
        println(PURCHASE_COUNT_MSG.format(count))
    }

    private fun drawTickets(tickets: List<LottoTicket>) {
        tickets.forEach { println(it.numbers) }
    }

    private fun drawMatchedCount(rankCounts: LottoRankCounts) {
        extractRanksInOutput().forEach {
            println(getMatchedCountMessage(it, rankCounts))
        }
    }

    private fun drawEarningRate(rate: EarningRate) {
        val lossMessage = if (rate.isLoss()) "손해" else "손해가 아니"
        println(EARNING_RATE_MSG.format(rate.value, lossMessage))
    }

    private fun extractRanksInOutput(): List<LottoRank> = LottoRank.entries.sorted().filterNot { it == LottoRank.MISS }

    private fun getMatchedCountMessage(rank: LottoRank, rankCounts: LottoRankCounts): String =
        getMatchedCountMessageFormat(rank).format(
            rank.countOfMatch,
            rank.winningMoney.value,
            getMatchedTicketCount(rank, rankCounts),
        )

    private fun getMatchedCountMessageFormat(rank: LottoRank): String = when (rank.isWithBonusMatch) {
        true -> MATCHED_COUNT_MSG
        false -> BONUS_MATCHED_COUNT_MSG_
    }

    private fun getMatchedTicketCount(rank: LottoRank, rankCounts: LottoRankCounts): Int =
        rankCounts.value[rank] ?: 0
}
