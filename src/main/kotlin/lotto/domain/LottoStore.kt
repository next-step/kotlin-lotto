package lotto.domain

private const val LOTTO_PRICE = 1000

class LottoStore(private val lottoGenerator: LottoGenerator) {
    fun buyLottos(money: Int): Lottos {
        val lottoCount = money / LOTTO_PRICE
        val lottos = List(lottoCount) {
            lottoGenerator.publish()
        }

        return Lottos(lottos)
    }
}
