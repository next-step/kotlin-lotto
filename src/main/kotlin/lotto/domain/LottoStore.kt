package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {

    fun buy(money: Int, manualLottoNumber: Int): Lottos {
        val lottoNumber = money / LOTTO_PRICE - manualLottoNumber
        require(lottoNumber > 0) { "랜덤 로또 개수는 음수일 수 없습니다." }
        return Lottos(List(lottoNumber) { lottoGenerator.generate() })
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
