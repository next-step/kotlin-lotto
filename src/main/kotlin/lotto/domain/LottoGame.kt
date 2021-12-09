package lotto.domain

class LottoGame(private val money: Int) {
    val totalLottoCount = money / PRICE
    private val lottoTickets = mutableListOf<Lotto>()

    fun buyLottoTickets(manualCount: Int, manualLottoTickets: List<Lotto>): List<Lotto> {
        manualLottoTickets.forEach { lottoTickets.add(it) }
        repeat(totalLottoCount - manualCount) { lottoTickets.add(Lotto.buyAuto()) }
        return lottoTickets
    }

    fun matchLottoNums(winningNums: Lotto, bonusNum: LottoNum): WinningStats {
        val winningStats = WinningStats(money)
        lottoTickets.forEach {
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
