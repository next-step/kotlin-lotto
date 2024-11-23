package lotto

object OutputView {
    fun printStatistics(winningStatistics: WinningStatistics) {
        println("당첨 통계")
        println("---------")
        println("3개 일치 (${RewardType.THIRD.winningAmount}원)- ${winningStatistics.map[RewardType.THIRD] ?: 0}개")
        println("4개 일치 (${RewardType.FOURTH.winningAmount}원)- ${winningStatistics.map[RewardType.FOURTH] ?: 0}개")
        println("5개 일치 (${RewardType.SECOND.winningAmount}원)- ${winningStatistics.map[RewardType.SECOND] ?: 0}개")
        println("6개 일치 (${RewardType.FIRST.winningAmount}원)- ${winningStatistics.map[RewardType.FIRST] ?: 0}개")
        println("총 수익률은 ${winningStatistics.profit}입니다.")
    }
}