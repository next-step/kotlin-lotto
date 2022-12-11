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
        println("3개 일치 (5000원)- ${result.ranks[Rank.FIFTH]}개")
        println("4개 일치 (50000원)- ${result.ranks[Rank.FOURTH]}개")
        println("5개 일치 (1500000원)- ${result.ranks[Rank.THIRD]}개")
        println("6개 일치 (2000000000원)- ${result.ranks[Rank.FIRST]}개")
        println("총 수익률은 ${result.rate}입니다.")
    }
}
