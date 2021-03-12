package lotto.domain

internal class Store(
    private val lottoPrice: Money = DEFAULT_LOTTO_PRICE,
    private val lottoNumsGenerator: LottoNumsGenerator = RandomLottoNumsGenerator()
) {

    internal fun sell(money: Money, selfLottosNums: List<List<Int>> = listOf()): LottoPaper {
        val selfLottos = selfLottosNums.map { Lotto.createLotto(it) }
        val autoLottoCount = (money / lottoPrice).value - selfLottosNums.size
        val autoLottos = (1..autoLottoCount).map { Lotto(lottoNumsGenerator.generate()) }
        return LottoPaper(selfLottos.plus(autoLottos))
    }

    companion object {
        private val DEFAULT_LOTTO_PRICE = Money(1000)
    }
}
