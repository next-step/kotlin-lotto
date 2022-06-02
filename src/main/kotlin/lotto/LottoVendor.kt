package lotto

class LottoVendor {
    fun sellLotto(price: Price): Lottos {
        val count = getCountOfLotto(price)
        val lottos = (1..count).map {
            Lotto.generator().generate(RandomGenerater())
        }
        return Lottos(lottos)
    }

    fun getCountOfLotto(price: Price): Int {
        val count = price.amount / LOTTO_PRICE
        require(count > 0)
        return count
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
