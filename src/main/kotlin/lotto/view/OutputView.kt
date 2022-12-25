package lotto.view

import lotto.model.LottoTicket
import lotto.model.Rank
import lotto.model.WinningStatistics

class OutputView {
    fun showQuantity(manualTicketQuantity: Int, autoTicketQuantity: Int) {
        println("수동으로 ${manualTicketQuantity}장, 자동으로 ${autoTicketQuantity}개를 구매했습니다.")
    }

    fun showLottoTicket(automaticLottoTickets: List<LottoTicket>) {
        for (lottoTicket in automaticLottoTickets) {
            println(lottoTicket.values)
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

    fun showManualNumber() {
        println("수동으로 구매할 번호를 입력해 주세요.")
    }
}
