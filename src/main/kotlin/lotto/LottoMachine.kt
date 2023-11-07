package lotto

private const val LOTTO_PRICE = 1000

class LottoMachine(lottoGenerator: LottoGenerator, money: Int) {
    val issuedLottos = (0 until money.issueLottoSize()).map { lottoGenerator.generate() }

    fun issueStatistics(lotto: Lotto): Statistics {
        val rank = issuedLottos[0].match(lotto)
        return Statistics(mapOf(rank to 1))
    }
}

private fun Int.issueLottoSize(): Int {
    return this / LOTTO_PRICE
}
