package presentation

import domain.LottoNumber
import domain.LottoWinningType
import domain.WinningResult
import util.round

class OutputView {
    companion object {
        fun printManualLottoInput() {
            println("수동으로 구매할 번호를 입력해 주세요.")
        }

        fun printLottoCount(
            manualLottoCount: Int,
            automaticLottoCount: Int,
        ) {
            println("수동으로 $manualLottoCount 장, 자동으로 $automaticLottoCount 개를 구매했습니다.")
        }

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
            val fifthCount = result[LottoWinningType.FIFTH] ?: 0
            println(
                """
                당첨 통계
                ---------
                3개 일치 (5,000원)- $fifthCount 개
                4개 일치 (50,000원)- $fourthCount 개
                5개 일치 (1,500,000원)- $thirdCount 개
                5개 일치,보너스볼 일치 (30,000,000원)- $secondCount 개
                6개 일치 (2,000,000,000원)- $firstCount 개
                총 수익률은 ${winningResult.profit.round(2)} 입니다. 
                """.trimIndent(),
            )
        }
    }
}
