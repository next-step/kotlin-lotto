package study.lotto.domain

class Lottos(lottoList: List<Lotto>) {
    private var lottos: List<Lotto> = lottoList

    val list = lottos.toList()

    fun count() = lottos.size

    companion object {
        fun generateLottos(purchaseAmount: Int): Lottos {
            val numberOfLottos = purchaseAmount / Lotto.PRICE_PER_TICKET
            val lottoList = (1..numberOfLottos).map { Lotto.generate() }
            return Lottos(lottoList)
        }
    }
}
