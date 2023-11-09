package lotto.domain

private const val LOTTO_PRICE = 1000

class LottoVendingMachine(val lottoGenerator: LottoGenerator) {
    fun generate(amount: Int, manualLottoCount: Int): List<Lotto> {
        val count = amount / LOTTO_PRICE - manualLottoCount
        return List(count) { lottoGenerator.generate() }
    }
}
