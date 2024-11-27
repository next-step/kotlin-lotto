package lotto.domain

class LottoStore {
    fun issueLottos(
        manualLottos: List<Lotto>,
        purchasedLottoCount: Int,
        generator: LottoNumberGenerator,
    ): PurchasedLottos {
        val autoCount = purchasedLottoCount - manualLottos.size
        val autoLottos = List(autoCount) { Lotto(generator.generate()) }
        return PurchasedLottos(manualLottos + autoLottos)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
