package lotto.domain

class LottoGame(private val money: Int) {
    val count = money / PRICE
    private val lottoNums = mutableListOf<Lotto>()

    fun makeLottoNums(): MutableList<Lotto> {
        repeat(count) { lottoNums.add(Lotto.buy()) }
        return lottoNums
    }

    fun matchLottoNums(winningNums: Lotto, bonusNum: Int): WinningStats {
        val winningStats = WinningStats(money)
        lottoNums.forEach {
            val matchCount = it.nums.intersect(winningNums.nums).size
            val matchBonus = it.nums.contains(bonusNum)
            winningStats.addMatchCount(Prize.findPrize(matchCount, matchBonus))
        }
        return winningStats
    }

    companion object {
        const val PRICE = 1000
    }
}
