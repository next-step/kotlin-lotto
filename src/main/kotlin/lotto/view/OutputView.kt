package lotto.view

import lotto.domain.Lotto
import lotto.domain.RewardType
import lotto.domain.WinningStatistics

object OutputView {
    fun printPurchaseResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.pickNumbers)
        }
    }

    fun printStatistics(winningStatistics: WinningStatistics) {
        println("당첨 통계")
        println("---------")
        this.printMatchCount(rewardType = RewardType.FOURTH, rewardMap = winningStatistics.rewardMap)
        this.printMatchCount(rewardType = RewardType.THIRD, rewardMap = winningStatistics.rewardMap)
        this.printMatchCount(rewardType = RewardType.SECOND, rewardMap = winningStatistics.rewardMap)
        this.printMatchCount(rewardType = RewardType.FIRST, rewardMap = winningStatistics.rewardMap)
        println("총 수익률은 ${winningStatistics.profit}입니다.")
    }

    private fun printMatchCount(
        rewardType: RewardType,
        rewardMap: Map<RewardType, Int>,
    ) {
        println("${rewardType.matchCount}개 일치 (${rewardType.winningAmount}원)- ${rewardMap[rewardType] ?: 0}개")
    }
}
