package lotto.view

import lotto.model.RandomLottoTicketGenerator
import lotto.model.Rank
import lotto.model.WinningStatistics

class ResultView {
    fun showQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun showLottoTicket(randomLottoTickets: List<RandomLottoTicketGenerator>) {
        for (lottoTicket in randomLottoTickets) {
            println(lottoTicket)
        }
    }

    fun showWinningStatistics(result: WinningStatistics) {
        var matchState = "당첨 통계\n---------\n"
        result.ranks.forEach {
            if (it.key == Rank.SECOND) {
                matchState += "${it.key.match}개 일치, 보너스 볼 일치 (${it.key.reward})- ${result.ranks[it.key]?.get(0)?.count}개\n"
            } else if (it.key.reward != 0) {
                matchState += "${it.key.match}개 일치 (${it.key.reward})- ${result.ranks[it.key]?.get(0)?.count}개\n"
            }
        }
        matchState += "\n총 수익률은 ${result.rate}입니다."
        println(matchState)
    }
}
