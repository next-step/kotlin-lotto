package lotto.domain

class LottoVendingMachine(val lottoGenerator: LottoGenerator) {
    fun generate(amount: Amount, manualLottoCount: Count): Lottos {
        val remainingCount = amount.purchasableCount() - manualLottoCount.count
        val lottos = List(remainingCount) { lottoGenerator.generate() }
        return Lottos(lottos)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
