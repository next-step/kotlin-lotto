package lotto.domain

internal class Store(
    private val lottoPrice: Money = DEFAULT_LOTTO_PRICE,
    private val lottoNumsGenerator: LottoNumsGenerator = RandomLottoNumsGenerator()
) {

    internal fun sell(money: Money): LottoPaper {
        val numberOfLotto = money / lottoPrice
        val lottos = (1..numberOfLotto.value).map { lottoNumsGenerator.generate() }
        return LottoPaper(lottos)
    }

    companion object {
        private val DEFAULT_LOTTO_PRICE = Money(1000)
    }
}
