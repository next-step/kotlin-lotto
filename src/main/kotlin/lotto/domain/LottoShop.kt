package lotto.domain

class LottoShop(
    private val lottoNumberGenerator: LottoNumberGenerator,
) {
    fun purchaseLottos(purchaseAmount: Long): List<Lotto> {
        val purchaseCount = (purchaseAmount / Lotto.PRICE).toInt()

        return List(purchaseCount) { Lotto(lottoNumberGenerator.generateNumbers()) }
    }
}
