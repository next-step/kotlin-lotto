package lotto.domain

const val LOTTO_PRICE = 1000

class LottoMachine(
    private val money: Int,
    lottoDispenser: LottoDispenser,
) {
    val issuedLottos = lottoDispenser.issue(money)

    fun issueStatistics(winningLotto: WinningLotto): Statistics {
        val statistics = issuedLottos
            .groupingBy { winningLotto.judge(it) }
            .eachCount()
        return Statistics(money, statistics)
    }
}

