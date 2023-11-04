package lotto.domain

private const val LOTTO_PRICE = 1000

object LottoVendingMachine {
    fun generate(amount: Int): List<Lotto> {
        val count = amount / LOTTO_PRICE
        val lottoNumbers = LottoNumbers()
        return (1..count).map { lottoNumbers.generate() }
    }
}
