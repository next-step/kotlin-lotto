package lotto.domain

const val LOTTO_PRICE = 1000

class LottoMachine(private val lottoGenerator: LottoGenerator) {
    private var issuedLottos = mutableListOf<Lotto>()
    private var money: Int = 0

    fun inputMoney(money: Int) {
        val newIssuedLottos = (0 until issuedLottoSize(money)).map { lottoGenerator.generate() }
        issuedLottos.addAll(newIssuedLottos)
        this.money += money
    }

    fun issueStatistics(winningLotto: WinningLotto): Statistics {
        val statistics = issuedLottos.groupingBy { winningLotto.judge(it) }.eachCount()
        return Statistics(money, statistics)
    }

    fun issuedLottos(): List<Lotto> {
        return issuedLottos.toList()
    }

    private fun issuedLottoSize(money: Int): Int {
        return money / LOTTO_PRICE
    }
}
