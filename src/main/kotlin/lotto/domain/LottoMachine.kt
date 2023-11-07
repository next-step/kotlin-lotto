package lotto.domain

class LottoMachine(val lottoPrice: Int = DEFAULT_LOTTO_PRICE) {
    fun purchase(money: Int): Lottos {
        return Lottos(money / lottoPrice)
    }
    companion object {
        private const val DEFAULT_LOTTO_PRICE = 1000
    }
}
