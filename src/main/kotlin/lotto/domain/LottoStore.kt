package lotto.domain

class LottoStore(
    private val lottoFactory: LottoFactory,
) {
    fun sell(lottoOrder: LottoOrder): Lottos {
        val manualLottos = lottoFactory.createManual(lottoOrder.manualLottoNumbers)
        val quantity = lottoOrder.remainingQuantity
        val autoLottos = lottoFactory.createAuto(quantity)

        return Lottos.from(autoLottos, manualLottos)
    }
}
