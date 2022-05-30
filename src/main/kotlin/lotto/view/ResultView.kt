package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.LottoTickets

object ResultView {
    fun printTickets(lottoTickets: LottoTickets) {
        println("${lottoTickets.lottoTickets.size}개를 구매했습니다.")

        lottoTickets.lottoTickets.forEach { lottoTicket ->
            println(lottoTicket.numbers.map { it.number })
        }
    }

    fun printResult(prizeResult: List<Pair<LottoPrize, Int>>, earnings: Double) {
        println("당첨 통계")
        prizeResult.forEach {
            val (prize, count) = it
            println("${prize.matchCount}개 일치${getBonusText(prize)} ${prize.price}원 ($count)개")
        }

        println("총 수익률은 ${earnings}입니다")
    }

    private fun getBonusText(prize: LottoPrize) = if (prize == LottoPrize.FIFTH_BONUS) ", 보너스 볼 일치" else ""
}
