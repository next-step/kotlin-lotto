package next.step.lotto.domain

object LottoStore {

    const val LOTTO_PRICE: Int = 1000

    fun buy(payment: Int, algorithm: LottoNumberGenerationAlgorithm): Lottos {
        val lottos = mutableSetOf<Lotto>()
        var remained = payment
        while (canBuy(remained)) {
            val lotto: Lotto = Lotto.of(algorithm())
            if (!lottos.contains(lotto)) {
                remained -= LOTTO_PRICE
                lottos.add(lotto)
            }
        }
        return Lottos(lottos)
    }

    private fun canBuy(payment: Int): Boolean = payment >= LOTTO_PRICE

}