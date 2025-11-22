package presentation

import domain.Amount
import domain.LottoWinningType
import domain.WinningResult
import util.round

class OutputView {
    companion object {
        fun printLottoCount(amount: Amount) {
            if (amount.getChange() == 0) {
                println("${amount.getPurchaseLottoCount()} 개를 구매했습니다.")
                return
            }
            println("${amount.getPurchaseLottoCount()} 개를 구매했습니다. 거스름돈은 ${amount.getChange()}입니다. 가져가세요.")
        }

        fun printLotto(lotto: Set<Int>) {
            println(lotto)
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
