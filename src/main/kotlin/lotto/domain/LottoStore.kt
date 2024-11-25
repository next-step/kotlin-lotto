package lotto.domain

class LottoStore {
    fun calculateLottoCount(amount: Int): Int {
        require(amount >= LOTTO_PRICE) { "구입 금액은 최소 1000원 이상이어야 합니다." }
        return amount / LOTTO_PRICE
    }

    fun issueLottos(
        manualLottos: List<Lotto>,
        lottoCount: Int,
        generator: LottoNumberGenerator,
    ): PurchasedLottos {
        val autoCount = lottoCount - manualLottos.size
        val autoLottos = List(autoCount) { Lotto(generator.generate()) }
        return PurchasedLottos(manualLottos + autoLottos)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
