package lotto

private const val LOTTO_PRICE = 1000

class LottoMachine(private val lottoGenerator: LottoGenerator) {

    fun issueLottos(money: Int): List<Lotto> {
        return (0 until money.issueLottoSize()).map { lottoGenerator.generate() }
    }
}

private fun Int.issueLottoSize(): Int {
    return this / LOTTO_PRICE
}
