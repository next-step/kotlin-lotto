package study.lotto.domain

class Lottos(private val list: List<Lotto>) : List<Lotto> by list {
    fun countMatches(winningLotto: Lotto) = list.map { it.countMatches(winningLotto) }

    companion object {
        fun generateLottos(purchaseAmount: Int): Lottos {
            require(purchaseAmount >= 0) {
                "purchaseAmount must be a positive value"
            }

            val numberOfLottos = purchaseAmount / Lotto.PRICE_PER_TICKET
            val lottoList = (1..numberOfLottos).map { Lotto.generate() }
            return Lottos(lottoList)
        }
    }
}
