package lotto.ui

import lotto.domain.LottoRank
import lotto.domain.LottoResults
import lotto.domain.UserLottos


object LottoGamePrinter {
    fun printAmountMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchaseMessage(userLottos: UserLottos) {
        println("${userLottos.getPurchaseLottoCount()}개를 구매했습니다.")
        println(userLottos)
    }

    fun printWinningStatistics(lottoResults: LottoResults, profitRate: Double) {
        println(
            """
        당첨 통계
        ---------
    """.trimIndent()
        )
        val sortedLottoRanks = LottoRank.entries
            .sortedBy { lottoRank -> lottoRank.prizeAmount }

        sortedLottoRanks.forEach { lottoRank ->
            val winningLottoCount = lottoResults.getWinningLottoCountBy(lottoRank)
            println("${lottoRank.matchCount}개 일치 (${lottoRank.prizeAmount}원) - ${winningLottoCount}개")
        }

        println("총 수익률은 ${"%.2f".format(profitRate)}입니다.")
    }
}