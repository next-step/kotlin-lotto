package lotto.domain

private const val LOTTO_PRICE = 1000

class LottoVendingMachine(val lottoGenerator: LottoGenerator) {
    fun generate(amount: Int, manualLottoCount: Int): Lottos {
        val count = amount / LOTTO_PRICE - manualLottoCount
        val lottos = List(count) { lottoGenerator.generate() }
        return Lottos(lottos)
    }
}
