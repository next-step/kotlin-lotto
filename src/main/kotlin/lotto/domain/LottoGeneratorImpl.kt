package lotto.domain

class LottoGeneratorImpl(
    private val money: Money,
    private val lottoNumberGenerator: LottoNumberGenerator = LottoNumberGeneratorImpl()
) : LottoGenerator {

    override fun generateLotto(): List<Lotto> {
        val purchasedLottoCount = Lotto.getPurchasedLottoCount(money)
        return (0 until purchasedLottoCount).map { Lotto.of(lottoNumberGenerator.generateLottoNumber()) }
    }
}
