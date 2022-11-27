package lotto.domain

class LottoStore(val lottoGenerator: LottoGenerator) {

    fun buy(money :Int) :List<Lotto>{
        val lottoNumber = money / LOTTO_PRICE
        return List(lottoNumber){ lottoGenerator.generate() }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
