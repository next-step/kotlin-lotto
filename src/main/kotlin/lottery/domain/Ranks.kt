package lottery.domain

class Ranks(lottos: Lottos, winningLotto: Lotto, private val price: Int) {
    val rank: List<Rank>

    init {
        rank = lottos.matchLottos(winningLotto)
    }

    fun rateOfReturn(): Double {
        return rank.sumOf { it.winningMoney }.div(price.toDouble())
    }

    fun isBenefit() = rateOfReturn() >= JUDGMENT_CRITERIA

    companion object {
        private const val JUDGMENT_CRITERIA = 1
    }
}
