package lotto.view

import lotto.domain.Lottery
import lotto.infra.port.OutputSystem
import lotto.vo.LottoScore
import lotto.vo.LottoSet

class LottoResultView(private val outputSystem: OutputSystem) {

    fun printResult(lottoSet: LottoSet, winningLottery: Lottery) {
        printHeadLine()
        staticalLottery(lottoSet, winningLottery)
    }

    private fun printHeadLine() {
        outputSystem.write("당첨 통계\n")
        outputSystem.write("-------\n")
    }

    private fun staticalLottery(lottoSet: LottoSet, winningLottery: Lottery) {
        val curriedPrintLottery = { rank: LottoScore -> { printLottery(rank, lottoSet, winningLottery) } }

        LottoScore
            .values()
            .drop(1)
            .map {
                curriedPrintLottery(it)()
            }

        outputSystem.write("총 수익률은 ${lottoSet.rate(winningLottery)}입니다.")
    }

    private fun printLottery(lotteryRank: LottoScore, lottoSet: LottoSet, winningLottery: Lottery) {
        val count = lottoSet.countPlace(winningLottery, lotteryRank)
        outputSystem.write("${lotteryRank.matchCount}개 일치(${lotteryRank.rewardMoney}원)-${count}개\n")
    }
}
