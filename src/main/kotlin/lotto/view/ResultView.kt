package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoRank
import lotto.domain.LottoTicket

object ResultView {

    fun writeLottoTicket(lottoTicket: LottoTicket) {
        println("${lottoTicket.lottos.size}개를 구매했습니다.")
        lottoTicket.lottos.forEach {
            println(it.numbers.map { number -> number.value })
        }
    }

    fun writeLottoRank(lottoRank: LottoRank) {
        val winningCount = lottoRank.getWinningCount()
        LottoPrize.WINNING_RANK.forEach { prize ->
            println("${prize.matchingCount}개 일치 (${prize.amount.value}원) - ${winningCount[prize] ?: 0}개")
        }
        println("총 수익률은 ${lottoRank.getProfitRate().value}입니다")
    }
}
