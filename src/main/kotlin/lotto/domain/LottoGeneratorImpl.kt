package lotto.domain

class LottoGeneratorImpl(
    private val lottoNumberGenerator: LottoNumberGenerator = LottoNumberGeneratorImpl()
) : LottoGenerator {

    override fun generateLotto(money: Money): List<Lotto> {
        val purchasedLottoCount = Lotto.getPurchasedLottoCount(money)
        return (0 until purchasedLottoCount).map { Lotto.from(lottoNumberGenerator.generateLottoNumber()) }
    }
}
