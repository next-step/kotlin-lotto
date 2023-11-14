package lotto.domain

class LottoShop(
    private val lottoNumberGenerator: LottoNumberGenerator,
) {
    fun purchaseLottos(purchaseAmount: Won, manualLottoNumbers: List<ManualLottoNumbers>): List<Lotto> {
        val purchaseCount = (purchaseAmount / Lotto.PRICE).amount.toInt()
        val manualLottoCount = manualLottoNumbers.size

        validatePurchasable(purchaseCount, manualLottoCount)

        val manualLottos = manualLottoNumbers.map { Lotto(it.numbers) }

        return manualLottos + purchaseAutoLottos(purchaseCount - manualLottoCount)
    }

    private fun validatePurchasable(purchasableCount: Int, manualLottoCount: Int) {
        require(manualLottoCount <= purchasableCount) { "Not enough money to purchase lotto." }
    }

    private fun purchaseAutoLottos(purchaseCount: Int): List<Lotto> {
        return List(purchaseCount) { Lotto(lottoNumberGenerator.generateNumbers()) }
    }
}
