package lotto.view.result

import lotto.domain.LottoPurchaseCount
import lotto.domain.LottoResultRank
import lotto.domain.LottoTicket
import java.math.BigDecimal
import java.math.RoundingMode

class ConsoleResultView : ResultView {
    override fun showPurchaseCount(purchaseCount: LottoPurchaseCount) {
        println("${purchaseCount.value}개를 구매했습니다.")
    }

    override fun showLottoTicketNumber(lottoTicket: LottoTicket) {
        lottoTicket.lottoPackages.forEach { println(it.getSortedNumbers()) }
    }

    override fun showResultStatistics(resultStatistics: Map<LottoResultRank, Int>, totalProfitRate: BigDecimal) {
        println("\n당첨 통계")
        println("---------")
        showMatchedCounts(resultStatistics)
        showTotalProfitRate(totalProfitRate)
    }

    private fun showMatchedCounts(resultStatistics: Map<LottoResultRank, Int>) {
        LottoResultRank.values()
            .filter { LottoResultRank.MISSED != it }
            .forEach { println("${it.matchedCount}개 일치 (${it.prizeMoney}원)- ${resultStatistics.getOrDefault(it, 0)}개") }
    }

    private fun showTotalProfitRate(totalProfitRate: BigDecimal) {
        println("총 수익률은 ${totalProfitRate.setScale(2, RoundingMode.HALF_UP)} 입니다")
    }
}
