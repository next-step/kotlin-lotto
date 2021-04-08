package lotto.view

import lotto.LottoPaper
import lotto.LottoRankPaper
import lotto.LottoRank

object OutputView {

    fun showPurchases(lottoPaper: LottoPaper) {
        val purchaseCount = lottoPaper.lottoNumbers.size
        println("${purchaseCount}개를 구매했습니다.")
        lottoPaper.lottoNumbers.forEach { println(it.numbers) }
    }

    fun showResult(lottoRank: LottoRankPaper) {
        println("당첨 통계")
        println("---------")

        LottoRank.values()
            .toList()
            .filter { it != LottoRank.NONE }
            .sortedByDescending { it.rank }
            .forEach {
                showPrint(it, lottoRank.getRankCount(it))
            }

        val prizeRate = lottoRank.getPrizeRate()
        val resultMessage = StringBuilder()
        resultMessage.apply {
            append("총 수익률은 ${prizeRate}입니다.")
            append(if (prizeRate < 1) "총 수익률은 ${prizeRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else "")
        }

        println(resultMessage)
    }

    private fun showPrint(rank: LottoRank, rankCount: Int) {
        var extraMessage = " "
        if (rank == LottoRank.SECOND) extraMessage = ", 보너스 볼 일치"
        println("${rank.matchCount}개 일치$extraMessage(${rank.prizeMoney}원)- ${rankCount}개")
    }
}
