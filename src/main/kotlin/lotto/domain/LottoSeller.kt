package lotto.domain

class LottoSeller(val lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator()) {
    fun getLottoPurchaseCount(purchasePrice: Int): Int {
        return purchasePrice.div(Lotto.PRICE)
    }

    fun sellLottos(
        purchasePrice: Int,
        selectedlottoNumbersList: List<LottoNumbers> = listOf(),
    ): Lottos {
        val lottoMachine = LottoMachine(lottoNumberGenerator)
        val selectedLottos = Lottos(selectedlottoNumbersList.map { Lotto.of(it) })
        val autoLottos = lottoMachine.makeLottos(getLottoPurchaseCount(purchasePrice) - selectedLottos.lottos.size)
        return Lottos(selectedLottos.lottos + autoLottos.lottos)
    }
}
