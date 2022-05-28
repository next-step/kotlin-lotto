package lotto.domain

class LottoShop {
    val randomNumberGenerator: RandomNumberGenerator = RandomNumberGenerator()

    fun purchase(cash: Int): PurchaseRecord {
        val lottos = (1..cash / LOTTO_PRICE).map { Lotto(randomNumberGenerator) }
        return PurchaseRecord(lottos)
    }

    fun getWinningNumber(): Lotto {
        return Lotto(randomNumberGenerator)
    }

    companion object LottoShop {
        const val LOTTO_PRICE = 1_000
    }
}
