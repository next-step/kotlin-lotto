package lotto.domain

@JvmInline
value class LottoVendingMachine(private val lottoNumbers: List<LottoNumber>) {
    companion object {
        private const val LOTTO_PRICE = 1000

        fun buy(purchaseAmount: Int): List<LottoNumber> {
            return List(getNumberOfLotto(purchaseAmount)) { LottoNumber() }
        }

        private fun getNumberOfLotto(purchaseAmount: Int): Int {
            return purchaseAmount / LOTTO_PRICE
        }
    }
}
