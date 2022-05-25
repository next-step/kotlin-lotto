package lotto.domain

class LottoSeller(
    private val lottoGenerator: LottoGenerator = RandomLottoGenerator
) {
    fun sellAutoLotto(receivedMoney: Int): LottoBundle {
        require(receivedMoney >= PRICE_OF_LOTTO) { "받은 금액이 로또 판매 금액보다 적습니다." }
        val numberOfLotto = receivedMoney / PRICE_OF_LOTTO

        val bundle = List(numberOfLotto) {
            lottoGenerator.generate()
        }

        return LottoBundle(bundle)
    }

    fun sellManualLotto(receivedMoney: Int, coupons: List<LottoCoupon>): LottoBundle {
        require(coupons.size * PRICE_OF_LOTTO == receivedMoney) { "로또를 구매하기 부족한 금액입니다" }
        
        val bundle = coupons.map { Lotto(it.numbers) }

        return LottoBundle(bundle)
    }

    companion object {
        private const val PRICE_OF_LOTTO = 1000
    }
}
