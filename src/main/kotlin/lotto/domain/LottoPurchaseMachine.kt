package lotto.domain

class LottoPurchaseMachine(private val lottoGenerator: () -> Lotto) {
    fun getLottoBundle(purchaseInfo: PurchaseInfo): LottoBundle {
        val autoLottoBundle = generateAutoLottoBundle(purchaseInfo.autoLottoCount())
        val manualLottoBundle = generateManualLottoBundle(purchaseInfo.manualLottos)
        return autoLottoBundle + manualLottoBundle
    }

    private fun generateAutoLottoBundle(count: Int): LottoBundle {
        val result = (1..count).map { lottoGenerator() }
        return LottoBundle(result)
    }

    private fun generateManualLottoBundle(lottos: List<List<LottoNumber>>): LottoBundle {
        val result = lottos.map { Lotto(it) }
        return LottoBundle(result)
    }
}
