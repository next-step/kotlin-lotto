package lotto.domain

class LottoStore private constructor(private val wallet: Wallet) {

    private var manualLottos: Lottos = Lottos.from(emptyList())
    private var autoLottos: Lottos = Lottos.from(emptyList())

    fun purchaseLotto(manualLottoNumberTexts: List<String> = emptyList()) {
        purchaseManualLottos(manualLottoNumberTexts)
        purchaseAutoLottos()
    }

    private fun purchaseManualLottos(manualLottoNumberTexts: List<String>) {
        val manualLottoNumbers = ManualLottoNumbers.generateManualLottoNumbers(manualLottoNumberTexts)
        manualLottos = Lottos.generateManualLottos(manualLottoNumbers)
        wallet.buyLotto(manualLottos.getSize())
    }

    private fun purchaseAutoLottos() {
        autoLottos = Lottos.generateAutoLottos(wallet)
        wallet.buyLotto(autoLottos.getSize())
    }

    fun getAllLottos(): Lottos = manualLottos + autoLottos
    fun getManualLottoSize(): Int = manualLottos.getSize()
    fun getAutoLottoSize(): Int = autoLottos.getSize()

    companion object {
        fun enter(wallet: Wallet): LottoStore = LottoStore(wallet)
    }
}
