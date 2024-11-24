package lotto.domain

class LottoSeller(val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    fun getLottoPurchaseCount(purchasePrice: Int): Int {
        return purchasePrice.div(Lotto.PRICE)
    }

    fun sellLottos(purchasePrice: Int): Lottos {
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        return lottoMachine.makeLottos(getLottoPurchaseCount(purchasePrice))
    }
}
