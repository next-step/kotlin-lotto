package lottoview

import lotto.LottoTicket
import lotto.LottoWinningInfo
import lotto.WinningPriceEnum

object LottoOutputView {

    fun displayIssuedLottos(issuedLottos: List<LottoTicket>) {
        issuedLottos.forEach {
            println(it.ticketList)
        }
    }

    fun resultForWinning(winningInfo: LottoWinningInfo) {
        println(WINNING_STATISTICS_MESSAGE)
        println(SEPARATOR_MESSAGE)

        winningInfo.scoreInfos.sortBy { it.match }
        winningInfo.scoreInfos.forEach {
            var message = CONTAIN_MESSAGE.format(it.match, it.price, it.count)
            if (it.match == WinningPriceEnum.FIVE_BONUS.number) {
                message = BONUS_CONTAIN_MESSAGE.format(5, it.price, it.count)
            }
            println(message)
        }
    }

    fun displayRevenue(revenuePercentage: Double) {
        println(REVENUE_MESSAGE.format(revenuePercentage))
    }

    const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    const val SEPARATOR_MESSAGE = "---------"
    const val CONTAIN_MESSAGE = "%d 개 일치 (%d원) - %d"
    const val BONUS_CONTAIN_MESSAGE = "%d 개 일치, 보너스 볼 일치 (%d원) - %d"
    const val REVENUE_MESSAGE = "총 수익률은 %.2f입니다."
}
