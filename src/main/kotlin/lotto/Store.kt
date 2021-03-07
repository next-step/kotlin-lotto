package lotto

internal class Store(
    private val lottoPrice: Money = DEFAULT_MONEY,
    private val lottoNumsGenerator: LottoNumsGenerator = RandomLottoNumsGenerator()
) {

    internal fun buy(money: Money): List<Lotto> {
        val count = money / lottoPrice
        return (1..count.value).map { Lotto(lottoNumsGenerator.generate()) }
    }

    companion object {
        private val DEFAULT_MONEY = Money(1000)
    }
}
