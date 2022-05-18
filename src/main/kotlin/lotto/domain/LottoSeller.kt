package lotto.domain

class LottoSeller {
    private val lottoMachine = LottoMachine()

    fun purchaseAuto(inputPrice: Long): List<Lotto> {
        val numberOfPurchases = inputPrice / LOTTO_PRICE
        return (1..numberOfPurchases)
            .toList()
            .map { lottoMachine.generateAuto() }
    }

    companion object {
        const val LOTTO_PRICE: Long = 1_000
    }
}
