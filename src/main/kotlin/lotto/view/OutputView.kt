package lotto.view

import lotto.constants.WinningRank
import lotto.domain.Lottos

object OutputView {

    fun printLotto(lottos: Lottos) {
        println("로또 ${lottos.getLottoCount()}개를 구매했습니다.")
        lottos.lottos.forEach {
            println(it.numbers)
        }
    }

    fun printWinningResult(winningRankList: List<WinningRank>) {
        println("당첨 통계")
        println("---------")
        winningRankList.printWinningResult(WinningRank.FOURTH)
        winningRankList.printWinningResult(WinningRank.THIRD)
        winningRankList.printWinningResult(WinningRank.SECOND)
        winningRankList.printWinningResult(WinningRank.FIRST)
    }

    private fun List<WinningRank>.printWinningResult(targetWinningRank: WinningRank) {
        val count = this.filter { it == targetWinningRank }.size
        println("${targetWinningRank.count}개 일치 (${targetWinningRank.money}원)- ${count}개")
    }

    fun printRateOfReturn(inputPrice: Int, winningRankList: List<WinningRank>) {
        val totalWinningMoney = winningRankList.sumOf { it.money }
        val rateOfReturn = totalWinningMoney.toDouble() / inputPrice.toDouble()
        println("총 수익률은 $rateOfReturn%입니다.")
    }
}
