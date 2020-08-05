package lotto.view

import lotto.domain.LottoSingleLine
import lotto.domain.LottoResult

fun printLottoTicket(list: List<LottoSingleLine>) {
    println("${list.size}개를 구입했습니다.")
    list.forEach {
        println("${it.lottoNumbers}")
    }
}

fun printResult(lines: List<LottoSingleLine>) {
    println("당첨통계")
    LottoResult.values()
        .filter { it.price > 0 }
        .forEach {
            println(resultString(it, lines))
        }
}

fun resultString(result: LottoResult, lines: List<LottoSingleLine>): String {
    return if (result.isBonus) {
        "${result.matchCount}개 일치, Bonus 일치 (${result.price}) - ${getMatchSize(result.matchCount, lines)}개"
    } else {
        "${result.matchCount}개 일치 (${result.price}) - ${getMatchSize(result.matchCount, lines)}개"
    }
}

fun getMatchSize(count: Int, list: List<LottoSingleLine>): Int {
    return list.filter { it.getResult().matchCount == count }.size
}
