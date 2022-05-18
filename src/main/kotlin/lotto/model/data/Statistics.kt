package lotto.model.data

class Statistics(results: Results, policy: Policy) {

    val lottoCount = results.resultList.size
    val totalWonAmount = results.resultList.sumOf { it.winning.winMoney }
    val totalCost = policy.priceOfLotto * this.lottoCount
    val winningRatio = this.totalWonAmount.toDouble() / this.totalCost.toDouble()
    val winningCountMap = results.toWinningCountMap()

    private fun Results.toWinningCountMap(): Map<Winning, Int> {
        return WinningSet.associateWith { winning -> this.getCountOfWinning(winning) }
            .toSortedMap { o1, o2 -> o1.winMoney - o2.winMoney }
    }

    private fun Results.getCountOfWinning(winning: Winning): Int =
        this.resultList.filter { it.winning == winning }.size
}
