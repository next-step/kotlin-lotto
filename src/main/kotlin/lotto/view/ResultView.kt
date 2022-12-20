package lotto.view

import lotto.model.LottoTicket
import lotto.model.WinningStatistics

class ResultView {
    fun showQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun showLottoTicket(lottoTickets: List<LottoTicket>) {
        for (lottoTicket in lottoTickets) {
            println(lottoTicket.lottoNumbers)
        }
    }

    fun showWinningStatistics(result: WinningStatistics) {
        println("당첨 통계")
        println("---------")
        for (rank in result.ranks) {
            if (rank.key.reward != 0) {
                println("${rank.key.match}개 일치 (${rank.key.reward})- ${result.ranks[rank.key]}개")
            }
        }
        println("총 수익률은 ${result.rate}입니다.")
    }
}
