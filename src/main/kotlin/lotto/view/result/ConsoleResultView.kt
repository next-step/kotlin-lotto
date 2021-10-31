package lotto.view.result

import lotto.domain.LottoPurchaseCount
import lotto.domain.LottoResult
import lotto.domain.LottoResultRank
import lotto.domain.LottoTicket
import java.math.BigDecimal
import java.math.RoundingMode

class ConsoleResultView : ResultView {
    override fun showPurchaseCount(purchaseCount: LottoPurchaseCount) {
        println("${purchaseCount.value}개를 구매했습니다.")
    }

    override fun showLottoTicketNumber(lottoTicket: LottoTicket) {
        lottoTicket
            .lottoPackages()
            .forEach { println(it.getSortedNumbers()) }
    }

    override fun showResultStatistics(result: LottoResult) {
        println("\n당첨 통계")
        println("---------")
        showResultPerRank(result.resultStatistics)
        showTotalProfitRate(result.profitRate)
    }

    private fun showResultPerRank(resultStatistics: Map<LottoResultRank, Int>) {
        LottoResultRank.values()
            .filter { LottoResultRank.MISSED != it }
            .forEach { showResultPerRank(it, resultStatistics) }
    }

    private fun showResultPerRank(
        it: LottoResultRank,
        resultStatistics: Map<LottoResultRank, Int>
    ) {
        println(
            "%d개 일치%s(%d원)- %d개".format(
                it.lottoResultRankKey.matchedCount.value,
                getBonusBallMatchedResultString(it),
                it.prizeMoney,
                resultStatistics.getOrDefault(
                    it,
                    0
                )
            )
        )
    }

    private fun getBonusBallMatchedResultString(it: LottoResultRank) =
        if (it.lottoResultRankKey.matchedBonusNumber) ", 보너스 볼 일치" else " "

    private fun showTotalProfitRate(totalProfitRate: BigDecimal) {
        println("총 수익률은 ${totalProfitRate.setScale(2, RoundingMode.HALF_UP)} 입니다")
    }
}
