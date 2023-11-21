package lotto.domain

const val LOTTO_PRICE = 1000

class LottoMachine(private val lottoGenerator: LottoGenerator) {
    private lateinit var issuedLottos: List<Lotto>
    private var money: Int = 0

    fun issueLottos(money: Int): List<Lotto> {
        this.issuedLottos = (0 until issuedLottoSize(money)).map { lottoGenerator.generate() }
        this.money = money
        return issuedLottos.toList()
    }

    fun issueStatistics(winningLotto: WinningLotto): Statistics {
        val statistics = issuedLottos
            .groupingBy { winningLotto.judge(it) }
            .eachCount()
        return Statistics(money, statistics)
    }

    private fun issuedLottoSize(money: Int): Int {
        return money / LOTTO_PRICE
    }
}
