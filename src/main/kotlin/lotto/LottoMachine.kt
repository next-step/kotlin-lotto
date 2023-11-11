package lotto

const val LOTTO_PRICE = 1000

class LottoMachine(lottoGenerator: LottoGenerator, private val money: Int) {
    val issuedLottos = (0 until issuedLottoSize(money)).map { lottoGenerator.generate() }

    fun issueStatistics(winningLotto: WinningLotto): Statistics {
        val statistics = issuedLottos.groupingBy { winningLotto.judge(it) }.eachCount()
        return Statistics(money, statistics)
    }

    private fun issuedLottoSize(money: Int): Int {
        return money / LOTTO_PRICE
    }
}
