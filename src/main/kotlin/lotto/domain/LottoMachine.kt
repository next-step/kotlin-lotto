package lotto.domain

class LottoMachine(
    private val lottoPrice: Int = DEFAULT_LOTTO_PRICE
) {
    fun payPriceAndGetCount(price: Int): Int{
        require(price > 0) { "지불하는 금액은 0보다 커야합니다" }
        return price / lottoPrice
    }

    fun generate(count: Int): List<Lotto> {
        return generateSequence { Lotto() }
            .take(count)
            .toList()
    }

    fun buy(price: Int): List<Lotto> {
        val count = payPriceAndGetCount(price)
        return generate(count)
    }

    companion object {
        private const val DEFAULT_LOTTO_PRICE = 1_000
    }
}