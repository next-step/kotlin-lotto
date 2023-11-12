package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoGameResult

private const val INFORMATION_MESSAGE = """
당첨 통계
---------"""

fun printLottoList(lottoList: List<Lotto>) {
    lottoList.forEach { println(it.state()) }
    println()
}

fun printLottoGameResult(lottoGameResult: LottoGameResult) {
    println(INFORMATION_MESSAGE)
    println(lottoGameResult.state())
}
