package lottoview

import lotto.LottoWinningInfo

object LottoOutputView {

    fun displayIssuedLottos(issuedLottos: List<List<Int>>) {
        issuedLottos.forEach {
            println(it)
        }
    }

    fun resultForWinning(winningInfo: LottoWinningInfo) {
        println(WINNING_STATISTICS_MESSAGE)
        println(SEPARATOR_MESSAGE)

        winningInfo.scoreInfos.forEach {
            println(CONTAIN_MESSAGE.format(it.match, it.price, it.count))
        }
    }

    fun displayRevenue(amount: Int, revenue: Int) {
        val revenuePercentage: Double = (revenue / amount).toDouble()
        println(REVENUE_MESSAGE.format(revenuePercentage))
    }

    const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    const val SEPARATOR_MESSAGE = "---------"
    const val CONTAIN_MESSAGE = "%d 개 일치 (%d원) - %d"
    const val REVENUE_MESSAGE = "총 수익률은 %.2f입니다."
}
