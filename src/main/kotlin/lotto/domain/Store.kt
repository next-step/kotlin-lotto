package lotto.domain

internal class Store(
    private val lottoPrice: Money = DEFAULT_LOTTO_PRICE,
    private val lottoNumsGenerator: LottoNumsGenerator = RandomLottoNumsGenerator()
) {

    internal fun sell(money: Money, selfLottos: List<Lotto> = listOf()): LottoPaper {
        val autoLottoCount = (money / lottoPrice).value - selfLottos.size
        val autoLottos = (1..autoLottoCount).map { Lotto(lottoNumsGenerator.generate(), true) }
        return LottoPaper(selfLottos.plus(autoLottos))
    }

    companion object {
        private val DEFAULT_LOTTO_PRICE = Money(1000)
    }
}
