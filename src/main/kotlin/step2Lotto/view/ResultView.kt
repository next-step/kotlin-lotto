package step2Lotto.view

import step2Lotto.domain.dto.Lotto
import step2Lotto.domain.dto.LottoRank

class ResultView {
    fun showLottoTicketQuantity(lottoTicketQuantity: Int) {
        println("${lottoTicketQuantity}개를 구매했습니다.")
    }

    fun showLottoTickets(lottoTickets: List<Lotto>) {
        lottoTickets.forEach {
            println(it.numbers)
        }
    }

    fun showLottoStatistics(statistics: List<LottoRank>) {
        println("당첨 통계")
        println("---------")
        LottoRank.values().forEach { lottoRank ->
            showLottoRank(lottoRank, statistics.count { it == lottoRank })
        }
    }

    private fun showLottoRank(lottoRank: LottoRank, count: Int) {
        when (lottoRank) {
            LottoRank.FIRST -> println("6개 일치 (${LottoRank.FIRST.prizeMoney}원) - ${count}개")
            LottoRank.THIRD -> println("5개 일치 (${LottoRank.THIRD.prizeMoney}원) - ${count}개")
            LottoRank.FOURTH -> println("4개 일치 (${LottoRank.FOURTH.prizeMoney}원) - ${count}개")
            LottoRank.FIFTH -> println("3개 일치 (${LottoRank.FIFTH.prizeMoney}원) - ${count}개")
            else -> return
        }
    }

    fun showProfitRate(profitRate: Double) {
        println("총 수익률은 $profitRate%입니다.")
    }
}
