package lotto.view.monitor

import lotto.model.number.LottoNumbers
import lotto.model.rank.LottoWinningRank
import lotto.model.statistics.LottoStatistics
import java.math.BigDecimal
import java.math.RoundingMode

class LottoMonitor : Monitor {
    override fun displayLottoPurchaseAmount() {
        println("구입금액을 입력해 주세요.")
    }

    override fun displayLottoPurchasesCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    override fun displayInputLastWeekLottoWinningNumbers() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    override fun displayIssuedLottoTickets(lottoTickets: List<LottoNumbers>) {
        lottoTickets.forEach { lottoNumbers ->
            println(lottoNumbers)
        }
        println()
    }

    override fun displayLottoStatistics(statistics: LottoStatistics) {
        println()
        println("당첨 통계")
        println("---------")
        displayRankStatistics(statistics.winningRank)
        displayProfitRate(statistics.profitRate)
    }

    private fun displayRankStatistics(winningRank: Map<Int, Int>) {
        (3..6).forEach { rank ->
            val count = winningRank[rank] ?: 0
            val prize = LottoWinningRank.DEFAULT_RANK_PRICE[rank] ?: 0
            println("${rank}개 일치 (${prize}원)- ${count}개")
        }
    }

    private fun displayProfitRate(profitRate: Double) {
        val rate =
            BigDecimal(profitRate)
                .setScale(2, RoundingMode.DOWN)
                .toDouble()

        if (profitRate > 1.0) {
            println("총 수익률은 ${rate}입니다.")
        } else {
            println("총 수익률은 ${rate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }
}
