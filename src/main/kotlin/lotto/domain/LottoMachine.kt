package lotto.domain

class LottoMachine {

    fun purchaseAuto(money: Long): List<Lotto> {
        val numberOfPurchases = money / LOTTO_PRICE
        return (1..numberOfPurchases)
            .toList()
            .map { generateAuto() }
    }

    private fun generateAuto(): Lotto {
        return Lotto(listOf(1, 2, 3, 4, 5, 6))
    }

    companion object {
        const val LOTTO_PRICE: Long = 1_000
    }
}
