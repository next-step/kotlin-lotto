package lotto.domain

class LottoGame(private val money: Int) {
    val count = money / PRICE
    private val lottoNums = mutableListOf<Lotto>()

    fun makeLottoNums(): MutableList<Lotto> {
        repeat(count) { lottoNums.add(Lotto.buy()) }
        return lottoNums
    }

    fun matchLottoNums(winningNums: Lotto): WinningStats {
        val winningStats = WinningStats(money)
        lottoNums.forEach {
            val matchCount = it.nums.intersect(winningNums.nums).size
            winningStats.addMatchCount(Prize.findPrize(matchCount))
        }
        return winningStats
    }

    companion object {
        const val PRICE = 1000
    }
}
