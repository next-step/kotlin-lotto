package lotto.view

import java.math.BigDecimal
import lotto.model.LottoRank
import lotto.model.LottoScore
import lotto.model.LottoTicket

object ResultView {

    fun printTickets(tickets: Collection<LottoTicket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { ticket ->
            println("[${ticket.numbers.joinToString(", ") { it.number.toString() }}]")
        }
        println()
    }

    fun printScore(score: LottoScore) {
        println()
        println("당첨 통계")
        println("---------")

        listOf(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
            .forEach {
                println("${it.countCondition}개 일치 (${it.prize}원) - ${score.count(it)}")
            }

        val ratio = score.ratio
        print("총 수익률은 ${ratio}입니다.")
        println(if (ratio < BigDecimal.ONE) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else "")
    }
}