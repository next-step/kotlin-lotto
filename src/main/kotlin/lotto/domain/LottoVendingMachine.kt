package lotto.domain

private const val LOTTO_PRICE = 1000

class LottoVendingMachine(val lottoGenerator: LottoGenerator) {
    fun generate(amount: Int): List<Lotto> {
        val count = amount / LOTTO_PRICE
        return List(count) { lottoGenerator.generate() }
    }
}
