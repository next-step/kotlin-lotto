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
    val list = LottoResult.values().filter { it.price > 0 }
    list.forEach {
        println("${it.matchCount}개 일치 (${it.price}) - ${getMatchSize(it.matchCount, lines)}개")
    }
}

fun getMatchSize(count: Int, list: List<LottoSingleLine>) {
    list.filter { it.getResult().matchCount == count }.size
}
