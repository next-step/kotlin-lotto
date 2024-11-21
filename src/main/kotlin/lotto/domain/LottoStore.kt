package lotto.domain

class LottoStore {
    fun calculateLottoCount(amount: Int): Int {
        require(amount >= LOTTO_PRICE) { "구입 금액은 최소 1000원 이상이어야 합니다." }
        return amount / LOTTO_PRICE
    }

    fun issueLottos(
        count: Int,
        generator: LottoNumberGenerator,
    ): PurchasedLottos {
        return PurchasedLottos(List(count) { Lotto(generator.generate()) })
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
