package lotto.view

import lotto.domain.LottoSingleLine
import lotto.domain.LottoResult

fun printLottoTicket(list: List<LottoSingleLine>) {
    println("${list.size}개를 구입했습니다.")
    list.forEach {
        println("${it.getNumbers()}")
    }
}

fun printResult(lines: List<LottoSingleLine>) {
    println("당첨통계")
    LottoResult.values().filter { it.price > 0 }
        .forEach { result ->
            println("${result.matchCount}개 일치 (${result.price})  - ${lines.filter { it.getResult().matchCount == result.matchCount }.size}개")
        }
}
