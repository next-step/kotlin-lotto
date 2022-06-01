package lotto.view

import lotto.infra.port.OutputSystem
import lotto.policy.LotteryPolicy
import lotto.vo.LotteryRank
import lotto.vo.LotterySet

class LottoResultView(private val outputSystem: OutputSystem) {

    fun printResult(lotterySet: LotterySet, winningNormalLottery: LotteryPolicy) {
        printHeadLine()
        staticalLottery(lotterySet, winningNormalLottery)
    }

    private fun printHeadLine() {
        outputSystem.write("당첨 통계\n")
        outputSystem.write("-------\n")
    }

    private fun staticalLottery(lotterySet: LotterySet, winningNormalLottery: LotteryPolicy) {
        val curriedPrintLottery = { rank: LotteryRank -> { printLottery(rank, lotterySet, winningNormalLottery) } }

        LotteryRank
            .values()
            .drop(1)
            .map {
                curriedPrintLottery(it)()
            }

        outputSystem.write("총 수익률은 ${lotterySet.rate(winningNormalLottery)}입니다.")
    }

    private fun printLottery(lotteryRank: LotteryRank, lotterySet: LotterySet, winningNormalLottery: LotteryPolicy) {
        val count = lotterySet.countPlace(winningNormalLottery, lotteryRank)
        outputSystem.write("${lotteryRank.matchCount}개 일치(${lotteryRank.rewardMoney}원)-${count}개\n")
    }
}
