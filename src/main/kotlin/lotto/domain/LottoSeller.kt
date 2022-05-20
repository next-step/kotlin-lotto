package lotto.domain

class LottoSeller(
    private val lottoGenerator: LottoGenerator = RandomLottoGenerator
) {
    fun sell(amountOfPurchase: Int): LottoBundle {
        require(amountOfPurchase >= PRICE_OF_LOTTO) { "받은 금액이 로또 판매 금액보다 적습니다." }
        val numberOfLotto = amountOfPurchase / PRICE_OF_LOTTO

        val bundle = mutableListOf<Lotto>()

        repeat(numberOfLotto) {
            bundle.add(lottoGenerator.generate())
        }

        return LottoBundle(bundle.toList())
    }

    companion object {
        private const val PRICE_OF_LOTTO = 1000
    }
}
