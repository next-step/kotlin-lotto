package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {

    fun buy(money: Int, manualLottoNumber: Int): Lottos {
        val lottoNumber = money / LOTTO_PRICE - manualLottoNumber
        require(lottoNumber > 0)
        return Lottos(List(lottoNumber) { lottoGenerator.generate() })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
