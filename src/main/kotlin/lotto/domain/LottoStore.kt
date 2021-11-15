package lotto.domain

class LottoStore {

    fun sellLotto(purchaseAutoLottoNumbers: Int = 0, manualLottoNumberTexts: ManualLottoNumbers): Lottos {
        val manualLottos = sellManualLottos(manualLottoNumberTexts)
        val autoLottos = sellAutoLottos(purchaseAutoLottoNumbers)
        return manualLottos + autoLottos
    }

    private fun sellManualLottos(manualLottoNumbers: ManualLottoNumbers): Lottos {
        return Lottos.generateManualLottos(manualLottoNumbers)
    }

    private fun sellAutoLottos(purchaseAutoLottoNumbers: Int): Lottos {
        return Lottos.generateAutoLottos(purchaseAutoLottoNumbers)
    }
}
