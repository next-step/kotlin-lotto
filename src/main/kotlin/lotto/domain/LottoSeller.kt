package lotto.domain

class LottoSeller {
    private val lottoMachine = LottoMachine()

    fun purchaseAuto(money: Long): List<Lotto> {
        val numberOfPurchases = money / LottoMachine.LOTTO_PRICE
        return (1..numberOfPurchases)
            .toList()
            .map { lottoMachine.generateAuto() }
    }
}
