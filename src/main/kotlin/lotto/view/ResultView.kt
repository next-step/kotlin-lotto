package lotto.view

import lotto.domain.LottoGameResult
import lotto.domain.LottoNumbers

private const val INFORMATION_MESSAGE = """
당첨 통계
---------"""

fun printLottoList(manualLottoList: List<LottoNumbers>, autoLottoList: List<LottoNumbers>) {
    println("수동으로 ${manualLottoList.size}장, 자동으로 ${autoLottoList.size}개를 구매했습니다.")
    manualLottoList.forEach { println(it.state()) }
    autoLottoList.forEach { println(it.state()) }
    println()
}

fun printLottoGameResult(lottoGameResult: LottoGameResult) {
    println(INFORMATION_MESSAGE)
    println(lottoGameResult.state())
}
