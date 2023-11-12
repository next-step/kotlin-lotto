package lotto.domain

class LottoShop(
    private val lottoNumberGenerator: LottoNumberGenerator,
) {
    fun purchaseLottos(purchaseAmount: Long, manualLottoNumbers: List<List<LottoNumber>>): List<Lotto> {
        val manualLottoCount = manualLottoNumbers.size
        val manualLottos = manualLottoNumbers.map(::Lotto)

        val purchaseCount = (purchaseAmount / Lotto.PRICE).toInt()

        require(manualLottoCount <= purchaseCount) { "Not enough money to purchase lotto." }

        val autoLottos = List(purchaseCount - manualLottoCount) { Lotto(lottoNumberGenerator.generateNumbers()) }

        return manualLottos + autoLottos
    }
}
