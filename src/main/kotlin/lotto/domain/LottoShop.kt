package lotto.domain

object LottoShop {
    private const val LOTTO_PRICE = 1000

    fun purchase(purchaseMoney: Long, manualPurchaseLottos: Lottos): Lottos {
        val manualPurchaseMoney = manualPurchaseLottos.size * LOTTO_PRICE

        val purchaseCount = purchaseCount(purchaseMoney - manualPurchaseMoney)

        val autoLottos = Lottos((1..purchaseCount).map { LottoGenerator.generate() })
        return manualPurchaseLottos + autoLottos
    }

    private fun purchaseCount(purchaseMoney: Long): Long {
        return purchaseMoney / LOTTO_PRICE
    }
}

object LottoGenerator {
    fun generate(): Lotto {
        return (LottoNumber.LOTTO_NUMBER_MIN..LottoNumber.LOTTO_NUMBER_MAX)
            .shuffled()
            .take(Lotto.LOTTO_NUMBERS_SIZE)
            .sorted()
            .let { Lotto(it) }
    }
}
