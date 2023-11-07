package lotto.domain

private const val LOTTO_PRICE = 1000

class LottoStore(private val lottoGenerator: LottoGenerator) {
    fun buyLottos(money: Int): List<Lotto> {
        val lottoCount = money / LOTTO_PRICE

        return List(lottoCount) {
            lottoGenerator.publish()
        }
    }
}
