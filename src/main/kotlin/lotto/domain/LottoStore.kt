package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {

    fun buy(money: Int): Lottos {
        val lottoNumber = money / LOTTO_PRICE
        return Lottos(List(lottoNumber) { lottoGenerator.generate() })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
