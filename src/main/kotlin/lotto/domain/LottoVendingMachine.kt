package lotto.domain

private const val LOTTO_PRICE = 1000

object LottoVendingMachine {
    fun generate(input: Int): List<Lotto> {
        val amount = input / LOTTO_PRICE
        val lottoNumbers = LottoNumbers()
        return (1..amount).map { lottoNumbers.generate() }
    }
}
