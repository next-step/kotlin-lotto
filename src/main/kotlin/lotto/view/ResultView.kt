package lotto.view

import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.domain.Result

fun printLottoTickets(lottoTickets: LottoTickets) {
    lottoTickets.tickets.forEach(::println)
    println()
}

fun printHowManyPurchase(count: Int) {
    println("${count}개를 구매했습니다.")
}

fun printResult(result: Result) {
    Rank.values().sliceArray(0..4).forEach {
        if (it.matchBonus) {
            println("${it.countOfMatch}개 일치, 보너스 볼 일치(${it.winningMoney}원) - ${result.values[it]}개")
        } else {
            println("${it.countOfMatch}개 일치 (${it.winningMoney}원) - ${result.values[it]}개")
        }
    }
}

fun printProfit(profit: Double) {
    println("총 수익률은 ${profit}입니다.")
}
