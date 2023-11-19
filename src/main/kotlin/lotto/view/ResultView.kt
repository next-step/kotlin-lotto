package lotto.view

import lotto.domain.LottoGameResult
import lotto.domain.LottoNumbers

private const val INFORMATION_MESSAGE = """
당첨 통계
---------"""

fun printLottoList(lottoList: List<LottoNumbers>) {
    lottoList.forEach { println(it.state()) }
    println()
}

fun printLottoGameResult(lottoGameResult: LottoGameResult) {
    println(INFORMATION_MESSAGE)
    println(lottoGameResult.state())
}
