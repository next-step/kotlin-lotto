package lotto.view

import lotto.model.Rank
import lotto.model.WinningStatistics

class ResultView {
    fun showQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun showLottoTicket(lottoTicketNumber: List<Int>) {
        println(lottoTicketNumber)
    }

    fun showWinningStatistics(result: WinningStatistics) {
        println("당첨 통계")
        println("---------")
        for (i in 3..6) {
            println("${Rank.of(i).match}개 일치 (${Rank.of(i).reward})- ${result.ranks[Rank.of(i)]}개")
        }
        println("총 수익률은 ${result.rate}입니다.")
    }
}
