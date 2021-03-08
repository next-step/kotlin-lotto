package lotto.domain

internal class Store(
    private val lottoPrice: Money = DEFAULT_MONEY,
    private val lottoNumsGenerator: LottoNumsGenerator = RandomLottoNumsGenerator()
) {

    internal fun sell(money: Money): LottoPaper {
        val count = money / lottoPrice
        val lottos = (1..count.value).map { Lotto(lottoNumsGenerator.generate()) }
        return LottoPaper(lottos)
    }

    companion object {
        private val DEFAULT_MONEY = Money(1000)
    }
}
