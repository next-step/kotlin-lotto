package game.view

import game.domain.lotto.Lotto
import game.domain.result.LottoResult
import game.domain.result.Rank

class ConsoleOutput : Output {
    override fun printPurchaseList(lotto: Lotto) {
        println()
        println("${lotto.tickets.size}개를 구매했습니다.")
        lotto.tickets.forEach { ticket ->
            println(ticket.numbers.sortedBy { it.value })
        }
    }

    override fun printStatistics(result: LottoResult) {
        println()
        println("당첨 통계")
        println("-------------")
        result.value
            .filter { it.key != Rank.NONE }
            .forEach { println("${it.key.matchCount}개 일치 (${it.key.amount})원 - ${it.value}개") }
        println("총 수익률은 ${result.profit()}입니다. (1이 넘는 경우 이익입니다.)")
    }
}