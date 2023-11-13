package lotto.domain

class LottoShop(
    private val lottoNumberGenerator: LottoNumberGenerator,
) {
    fun purchaseLottos(purchaseAmount: Won, manualLottoNumbers: List<ManualLottoNumbers>): List<Lotto> {
        val manualLottoCount = manualLottoNumbers.size
        val manualLottos = manualLottoNumbers.map { Lotto(it.numbers) }

        val purchaseCount = (purchaseAmount / Lotto.PRICE).amount.toInt()

        require(manualLottoCount <= purchaseCount) { "Not enough money to purchase lotto." }

        val autoLottos = List(purchaseCount - manualLottoCount) { Lotto(lottoNumberGenerator.generateNumbers()) }

        return manualLottos + autoLottos
    }
}
