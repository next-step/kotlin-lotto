package lotto.view

import lotto.domain.LottoPrize
import lotto.domain.Purchase
import java.math.BigDecimal

object ResultView {
    fun printTickets(purchase: Purchase) {
        println("수동으로 ${purchase.manualTickets.lottoTickets.size}장, 자동으로 ${purchase.autoTickets.lottoTickets.size}개를 구매했습니다.")

        purchase.totalTickets.lottoTickets.forEach { lottoTicket ->
            println(lottoTicket.numbers.map { it.number })
        }
    }

    fun printResult(prizeResult: List<Pair<LottoPrize, Int>>, earnings: BigDecimal) {
        println("당첨 통계")
        prizeResult.forEach {
            val (prize, count) = it
            println("${prize.matchCount}개 일치${getBonusText(prize)} ${prize.price.amount}원 ($count)개")
        }

        println("총 수익률은 ${earnings}입니다")
    }

    private fun getBonusText(prize: LottoPrize) = if (prize == LottoPrize.FIFTH_BONUS) ", 보너스 볼 일치" else ""
}
