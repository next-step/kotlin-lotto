package lottery.domain

class Ranks(lottos: Lottos, winningLotto: WinningLotto, private val price: Int) {
    val rank: List<Rank>

    init {
        rank = lottos.matchLottos(winningLotto)
    }

    fun calculateProfitabilityRatio(): Double {
        return rank.sumOf { it.winningMoney }.div(price.toDouble())
    }

    fun isProfitable() = calculateProfitabilityRatio() >= JUDGMENT_CRITERIA

    companion object {
        private const val JUDGMENT_CRITERIA = 1
    }
}
