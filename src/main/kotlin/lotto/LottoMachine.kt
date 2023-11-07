package lotto

private const val LOTTO_PRICE = 1000

class LottoMachine(lottoGenerator: LottoGenerator, private val money: Int) {
    val issuedLottos = (0 until money.issueLottoSize()).map { lottoGenerator.generate() }

    fun issueStatistics(winningLotto: Lotto): Statistics {
        val statistics = issuedLottos.groupingBy { it.matchedCount(winningLotto) }.eachCount()
        return Statistics(money, statistics)
    }
}

private fun Int.issueLottoSize(): Int {
    return this / LOTTO_PRICE
}
