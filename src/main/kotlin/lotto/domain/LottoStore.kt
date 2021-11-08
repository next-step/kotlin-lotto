package lotto.domain

class LottoStore private constructor(private val manualLottos: Lottos, private val autoLottos: Lottos) {

    fun getAllLottos(): Lottos = manualLottos + autoLottos
    fun getManualLottoSize(): Int = manualLottos.getSize()
    fun getAutoLottoSize(): Int = autoLottos.getSize()

    companion object {
        fun purchaseLotto(wallet: Wallet, manualLottoNumberTexts: List<String> = emptyList()): LottoStore {
            val manualLottoNumbers = ManualLottoNumbers.generateManualLottoNumbers(manualLottoNumberTexts).toList()
            wallet.buyManualLotto(manualLottoNumbers.size)
            return LottoStore(Lottos.buyManualLottos(manualLottoNumbers), Lottos.buyAutoLottos(wallet))
        }
    }
}
