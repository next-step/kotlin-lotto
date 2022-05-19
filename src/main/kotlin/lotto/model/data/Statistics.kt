package lotto.model.data

class Statistics(results: Results, policy: Policy) {
    val lottoCount = results.size
    val totalWonAmount = results.sumOf { it.winning.winMoney }
    val totalCost = policy.priceOfLotto * this.lottoCount
    val winningRatio = this.totalWonAmount.toDouble() / this.totalCost.toDouble()
    val winningCountMap = results.toWinningCountMap()
}
