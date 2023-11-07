package lotto

private const val LOTTO_PRICE = 1000

class LottoMachine(private val lottoGenerator: LottoGenerator) {

    fun issueLottos(money: Int): List<Lotto> {
        return (0 until money.issueLottoSize()).map { lottoGenerator.generate() }
    }

    fun issueStatistics(lotto: Lotto): Statistics {
        val issueLotto = issueLottos(1000).get(0)
        val rank = issueLotto.match(lotto)
        return Statistics(mapOf(rank to 1))
    }
}

private fun Int.issueLottoSize(): Int {
    return this / LOTTO_PRICE
}
