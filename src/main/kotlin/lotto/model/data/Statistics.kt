package lotto.model.data

class Statistics(results: Results, policy: Policy) {
    val lottoCount = results.resultList.size
    val totalWonAmount = results.resultList.sumOf { it.winning.winMoney }
    val totalCost = policy.priceOfLotto * this.lottoCount
    val winningRatio = this.totalWonAmount.toDouble() / this.totalCost.toDouble()
    val winningCountMap =
        WinningSet.associateWith { winning -> results.resultList.filter { it.winning == winning }.size }
            .toSortedMap { o1, o2 -> o1.winMoney - o2.winMoney }
}
