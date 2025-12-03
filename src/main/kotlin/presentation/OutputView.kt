package presentation

import domain.LottoNumber
import domain.LottoWinningType
import domain.WinningResult
import util.round

class OutputView {
    companion object {
        fun printLotto(lotto: Set<LottoNumber>) {
            println(lotto.map { it.number }.toList())
        }

        fun printResult(winningResult: WinningResult) {
            val result =
                winningResult.result
            val firstCount = result[LottoWinningType.FIRST] ?: 0
            val secondCount = result[LottoWinningType.SECOND] ?: 0
            val thirdCount = result[LottoWinningType.THIRD] ?: 0
            val fourthCount = result[LottoWinningType.FOURTH] ?: 0
            println(
                """
                당첨 통계
                ---------
                3개 일치 (5000원)- $fourthCount 개
                4개 일치 (50000원)- $thirdCount 개
                5개 일치 (1500000원)- $secondCount 개
                6개 일치 (2000000000원)- $firstCount 개
                총 수익률은 ${winningResult.profit.round(2)} 입니다. 
                """.trimIndent(),
            )
        }
    }
}
