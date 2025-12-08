package presentation

import domain.lotto.Lotto
import domain.purchase.LottoPurchaseInfo
import domain.winning.LottoWinningType
import domain.winning.WinningResult
import util.round

class OutputView {
    companion object {
        fun printLottoCount(lottoPurchaseInfo: LottoPurchaseInfo) {
            println(
                "수동으로 ${lottoPurchaseInfo.manualLottoCount}장, 자동으로 ${lottoPurchaseInfo.autoLottoCount}개를 구매했습니다. " +
                    "총 구입금액 ${lottoPurchaseInfo.purchaseAmount}, 거스름돈은 ${lottoPurchaseInfo.change}입니다. 가져가세요.",
            )
        }

        fun printLotto(lotto: Lotto) {
            println(lotto.numbers.map { it.number })
        }

        fun printResult(winningResult: WinningResult) {
            val result =
                winningResult.result
            val firstCount = result[LottoWinningType.FIRST] ?: 0
            val secondWithBonusCount = result[LottoWinningType.SECOND_WITH_BONUS] ?: 0
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
                5개 일치, 보너스 볼 일치 (30000000원)- $secondWithBonusCount 개
                6개 일치 (2000000000원)- $firstCount 개
                총 수익률은 ${winningResult.profit.round(2)} 입니다. 
                """.trimIndent(),
            )
        }
    }
}
