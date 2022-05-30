package lotto.domain

class LottoShop {
    val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()

    fun purchase(payment: Payment): PurchaseRecord {
        val lottos = (1..payment.cash / LOTTO_PRICE).map { Lotto(randomNumberGenerator) }
        return PurchaseRecord(lottos)
    }

    fun getWinningNumber(): Lotto {
        return Lotto(randomNumberGenerator)
    }

    companion object LottoShop {
        const val LOTTO_PRICE = 1_000
    }
}
