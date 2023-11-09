package lotto.view

import lotto.model.LottoPrize
import lotto.model.LottoResult
import lotto.utils.MatchedCount
import lotto.utils.Prize
import lotto.utils.TicketCount

class LottoResultView {
    fun printLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        printLottoPrizes(lottoResult)
        printRevenueRate(lottoResult)
    }

    private fun printLottoPrizes(lottoResult: LottoResult) {
        val grouped: List<Pair<MatchedCount, TicketCount>> = getLottoPrizesByMatchedCount(lottoResult)

        grouped.forEach {
            val matchedCount = it.first
            val ticketCount = it.second
            val prize = LottoPrize.getPrize(matchedCount)

            printLottoPrize(matchedCount, prize, ticketCount)
        }
    }

    private fun printLottoPrize(matchedCount: MatchedCount, prize: Prize, ticketCount: TicketCount) {
        println("${matchedCount}개 일치 (${prize}원)- ${ticketCount}개")
    }

    private fun getLottoPrizesByMatchedCount(lottoResult: LottoResult): List<Pair<MatchedCount, TicketCount>> {
        return lottoResult.groupLottoPrizesByMatchedCount()
            .entries
            .sortedBy { it.key }
            .map { Pair(it.key, it.value) }
            .toList()
    }

    private fun printRevenueRate(lottoResult: LottoResult) {
        println("총 수익률은 ${lottoResult.revenueRate}입니다.\n")
    }
}
