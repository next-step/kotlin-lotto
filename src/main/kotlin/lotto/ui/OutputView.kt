package lotto.ui

import lotto.domain.Lottoes
import lotto.domain.LottoesRank
import lotto.domain.Money
import lotto.domain.Rank

class OutputView {

    fun printPurchasedLottoes(manuals: Lottoes, autoes: Lottoes) {
        println("수동으로 ${manuals.toList().size}장, 자동으로 ${autoes.toList().size}개를 구매했습니다.")
        for (manualLotto in manuals.toList()) {
            println(manualLotto.value.toString())
        }

        for (autoLotto in autoes.toList()) {
            println(autoLotto.value.toString())
        }
    }

    fun printLottoesResult(money: Money, manualRanks: LottoesRank, autoRanks: LottoesRank) {
        val manualRankMap = manualRanks.getRanks()
        val autoRankMap = autoRanks.getRanks()
        println("\n당첨 통계")
        println("------------")
        println("3개 일치 (5000원) - ${(manualRankMap[Rank.FIFTH] ?: 0) + (autoRankMap[Rank.FIFTH] ?: 0)}개")
        println("4개 일치 (50,000원) - ${(manualRankMap[Rank.FOURTH] ?: 0) + (autoRankMap[Rank.FOURTH] ?: 0)}개")
        println("5개 일치 (1,500,000원) - ${(manualRankMap[Rank.THIRD] ?: 0) + (autoRankMap[Rank.THIRD] ?: 0)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${(manualRankMap[Rank.SECOND] ?: 0) + (autoRankMap[Rank.SECOND] ?: 0)}개")
        println("6개 일치 (2,000,000,000원) - ${(manualRankMap[Rank.FIRST] ?: 0) + (autoRankMap[Rank.FIRST] ?: 0)}개")

        printRateOfReturn(money, manualRanks, autoRanks)
    }

    private fun printRateOfReturn(money: Money, manualRanks: LottoesRank, autoRanks: LottoesRank) {
        val manualLottesMoney = manualRanks.getWinningMoney()
        val autoLottesMoney = autoRanks.getWinningMoney()
        println("총 수익률은 ${money.calculateRateOfReturn(manualLottesMoney + autoLottesMoney)}입니다.")
    }
}
