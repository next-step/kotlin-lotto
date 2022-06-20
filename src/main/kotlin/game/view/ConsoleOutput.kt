package game.view

import game.domain.lotto.Lotto
import game.domain.result.LottoResult
import game.domain.result.Rank

class ConsoleOutput : Output {
    override fun printPurchaseList(lotto: Lotto) {
        println()
        println("${lotto.tickets.size}개를 구매했습니다.")
        lotto.tickets.forEach { ticket ->
            println(ticket.numbers.map { it.value }.sortedBy { it })
        }
    }

    override fun printStatistics(result: LottoResult) {
        println()
        println("당첨 통계")
        println("-------------")
        Rank.values()
            .filter { it != Rank.NONE }
            .forEach { println("${it.matchCount}개 일치 (${it.amount})원 - ${result.value[it] ?: 0}개") }
        println("총 수익률은 ${result.profit()}입니다. (1이 넘는 경우 이익입니다.)")
    }
}
