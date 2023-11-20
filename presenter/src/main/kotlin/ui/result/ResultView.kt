package ui.result

import org.bmsk.domain.model.lotto.LotteryGenerator
import org.bmsk.domain.model.lotto.LottoLottery
import org.bmsk.domain.model.statistics.LottoStatisticsAnalyzer

class ResultView {
    fun displayPurchasedLottoLotteries(purchaseAmount: Int): List<LottoLottery> {
        val count = purchaseAmount / LottoLottery.DEFAULT_PRICE
        println("${count}개를 구매했습니다.")
        val lotteries = LotteryGenerator().generateByCount(count)
        return lotteries.onEach { lotto ->
            println(lotto.numbers)
        }
    }

    fun displayWinningStatistics(lotteries: List<LottoLottery>, winningNumbers: List<Int>) {
        val analyzer = LottoStatisticsAnalyzer(lotteries)
        val statistics = analyzer.calculateLottoStatistics(winningNumbers)
        val note = if (statistics.totalProfitRate < 1) {
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        } else {
            ""
        }
        println("\n당첨 통계\n---------")
        println("3개 일치 (5000원)- ${statistics.numberOfMatches3}개")
        println("4개 일치 (50000원)- ${statistics.numberOfMatches4}개")
        println("5개 일치 (1500000원)- ${statistics.numberOfMatches5}개")
        println("6개 일치 (2000000000원)- ${statistics.numberOfMatches6}개")
        println("총 수익률은 ${statistics.totalProfitRate}입니다." + note)
    }
}
