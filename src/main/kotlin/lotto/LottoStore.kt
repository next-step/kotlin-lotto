package lotto

class LottoStore(
    private val lottoFactory: LottoFactory,
) {
    fun sell(money: Money): Lottos {
        val quantity = money.value / LOTTO_PRICE
        val lottos = lottoFactory.create(quantity)

        return Lottos(lottos)
    }
}
