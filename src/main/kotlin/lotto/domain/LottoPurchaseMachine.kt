package lotto.domain

object LottoPurchaseMachine {
    fun getLottos(purchaseInfo: PurchaseInfo): List<Lotto> {
        val autoLottos = generateAutoLottos(purchaseInfo.autoLottoCount())
        val manualLottos = generateManualLottos(purchaseInfo.manualLottos)
        return autoLottos + manualLottos
    }

    private fun generateAutoLottos(count: Int): List<Lotto> {
        return (1..count).map { RandomLottoFactory.generate() }
    }

    private fun generateManualLottos(lottos: List<List<LottoNumber>>): List<Lotto> {
        return lottos.map { Lotto(it) }
    }
}
