package lotto.view

import java.math.BigDecimal
import lotto.model.LottoRank
import lotto.model.LottoScore
import lotto.model.LottoTicket
import lotto.model.LottoTicket.Companion.automaticSize
import lotto.model.LottoTicket.Companion.manualSize

object ResultView {

    fun printTickets(tickets: Collection<LottoTicket>) {
        println()
        println("수동으로 ${tickets.manualSize}, 자동으로 ${tickets.automaticSize}개를 구매했습니다.")
        tickets.forEach { ticket ->
            println("[${ticket.lotto.numbers.map { it.number }.sorted().joinToString(", ")}]")
        }
        println()
    }

    fun printScore(score: LottoScore) {
        println()
        println("당첨 통계")
        println("---------")

        listOf(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
            .forEach {
                if (it == LottoRank.SECOND) {
                    println("${it.countCondition}개 일치, 보너스 볼 일치 (${it.prize}원) - ${score countBy it}")
                    return@forEach
                }
                println("${it.countCondition}개 일치 (${it.prize}원) - ${score countBy it}")
            }

        val ratio = score.ratio
        print("총 수익률은 ${ratio}입니다.")
        println(if (ratio < BigDecimal.ONE) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else "")
    }
}
