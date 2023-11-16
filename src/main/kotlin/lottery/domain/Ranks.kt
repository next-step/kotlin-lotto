package lottery.domain

class Ranks(val rank: List<Rank>, price: Int) {
    val profitMargin: Double = rank.sumOf { it.winningMoney }
        .div(price.toDouble())
    val isProfitable: Boolean = profitMargin >= JUDGMENT_CRITERIA

    constructor(lottos: Lottos, winningLotto: WinningLotto, price: Int) : this(lottos.matchLottos(winningLotto), price)

    companion object {
        private const val JUDGMENT_CRITERIA = 1
    }
}
