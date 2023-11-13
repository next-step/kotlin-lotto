package lottery.domain

class Ranks(lottos: Lottos, winningLotto: WinningLotto, price: Int) {
    val rank: List<Rank>
    val profitMargin: Double
    val isProfitable: Boolean

    init {
        rank = lottos.matchLottos(winningLotto)
        profitMargin = rank.sumOf { it.winningMoney }.div(price.toDouble())
        isProfitable = profitMargin >= JUDGMENT_CRITERIA
    }

    companion object {
        private const val JUDGMENT_CRITERIA = 1
    }
}
