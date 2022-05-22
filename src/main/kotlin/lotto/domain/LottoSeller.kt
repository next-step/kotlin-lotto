package lotto.domain

class LottoSeller {
    private val lottoMachine = LottoMachine()

    fun purchaseAuto(inputPrice: Long): List<Lotto> {
        return List(numberOfPurchases(inputPrice)) {
            lottoMachine.generate()
        }
    }

    private fun numberOfPurchases(inputPrice: Long): Int {
        return (inputPrice / LOTTO_PRICE).toInt()
    }

    companion object {
        const val LOTTO_PRICE: Long = 1_000
    }
}
