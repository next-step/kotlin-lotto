package lotto.view

import lotto.model.LottoTicket
import lotto.model.Rank
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
        result.ranks.forEach {
            if (it.key == Rank.SECOND) {
                println("${it.key.match}개 일치, 보너스 볼 일치 (${it.key.reward})- ${result.ranks[it.key]}개")
            } else if (it.key.reward != 0) {
                println("${it.key.match}개 일치 (${it.key.reward})- ${result.ranks[it.key]}개")
            }
        }
        println("총 수익률은 ${result.rate}입니다.")
    }
}
