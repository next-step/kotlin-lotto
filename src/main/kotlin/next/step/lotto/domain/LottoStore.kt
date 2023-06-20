package next.step.lotto.domain

object LottoStore {

    private const val LOTTO_PRICE: Int = 1000

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

    fun buy(payment: Int, lottos: Lottos): Int {
        val remained = payment - lottos.size() * LOTTO_PRICE
        require(remained >= 0) { "${payment}원으로는 로또를 ${lottos.size()}개 살 수 없습니다." }
        return remained
    }


}