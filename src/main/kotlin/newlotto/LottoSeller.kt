package newlotto

class LottoSeller(private val lottoNumberFactory: LottoNumberFactory) {
    fun sell(purchaseAmount: Int): List<Lotto> {
        val numberOfLotto = purchaseAmount / lottoPrice
        return (1..numberOfLotto).map{ lottoNumberFactory.generate() }
    }

    companion object {
        private const val lottoPrice = 1000
    }
}
