package lotto.domain

class LottoShop {
    val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()

    fun purchase(count: Int): PurchaseRecord {
        val lottos = (1..count).map { Lotto(randomNumberGenerator) }
        return PurchaseRecord(lottos)
    }

    companion object LottoShop {
        const val LOTTO_PRICE = 1_000
        fun getAvailableNumberOfLotto(payment: Payment): Int {
            return payment.cash / LOTTO_PRICE
        }
    }
}
