package lotto.domain

class LottoSeller(val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    fun getLottoPurchaseCount(purchasePrice: Int): Int {
        return purchasePrice.div(LOTTO_PRICE)
    }

    fun sellLottos(purchasePrice: Int): Lottos {
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        return lottoMachine.makeLottos(getLottoPurchaseCount(purchasePrice))
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
