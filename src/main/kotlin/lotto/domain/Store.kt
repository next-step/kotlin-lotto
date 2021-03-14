package lotto.domain

internal class Store(
    private val lottoPrice: Money = DEFAULT_LOTTO_PRICE,
    private val lottoNumsGenerator: LottoNumsGenerator = RandomLottoNumsGenerator()
) {
    internal fun sell(money: Money, selfLottoNumsList: List<List<LottoNum>> = listOf()): LottoPaper {
        val selfLottos = selfLottoNumsList.map { Lotto(it) }
        val autoLottoCount = (money / lottoPrice).value - selfLottoNumsList.size
        val autoLottos = (1..autoLottoCount).map { Lotto(lottoNumsGenerator.generate()) }
        return LottoPaper(selfLottos.plus(autoLottos))
    }

    companion object {
        private val DEFAULT_LOTTO_PRICE = Money(1000)
    }
}
