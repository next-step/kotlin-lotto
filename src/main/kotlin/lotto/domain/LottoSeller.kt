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
        val rewardPriceMap = mapOf<Int, Long> (
            3 to 5_000,
            4 to 50_000,
            5 to 1_500_000,
            6 to 2_000_000_000
        )
    }
}
