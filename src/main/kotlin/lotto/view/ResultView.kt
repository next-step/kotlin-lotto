package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.Result

fun printLottoTickets(lottoTickets: LottoTickets) {
    lottoTickets.tickets.forEach(::println)
    println()
}

fun printHowManyPurchase(count: Int) {
    println("${count}를 구매했습니다.")
}

fun printResult(result: Result) {
    (3..6).forEach {
        println("${it}개 일치 (${Result.prizeMoney[it]}원) - ${result.values[it]}개")
    }
}

fun printProfit(profit: Double) {
    println("총 수익률은 ${profit}입니다.")
}
