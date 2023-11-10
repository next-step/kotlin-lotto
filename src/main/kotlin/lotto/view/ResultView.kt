package lotto.view

import lotto.Lotto
import lotto.LottoGameResult

private const val INFORMATION_MESSAGE = """
당첨 통계
---------"""

fun printLottoList(lottoList: List<Lotto>) {
    lottoList.forEach { println(it) }
    println()
}

fun printLottoGameResult(lottoGameResult: LottoGameResult) {
    println(INFORMATION_MESSAGE)
    println(lottoGameResult)
}
