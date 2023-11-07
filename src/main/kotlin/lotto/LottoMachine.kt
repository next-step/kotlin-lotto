package lotto

private const val LOTTO_PRICE = 1000

class LottoMachine(lottoGenerator: LottoGenerator, money: Int) {
    val issuedLottos = (0 until money.issueLottoSize()).map { lottoGenerator.generate() }

    fun issueStatistics(winningLotto: Lotto): Statistics {
        val matchedCount = issuedLottos[0].matchedCount(winningLotto)
        return Statistics(mapOf(matchedCount to 1))
    }
}

private fun Int.issueLottoSize(): Int {
    return this / LOTTO_PRICE
}
