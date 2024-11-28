package lotto.domain

class LottoService(
    private val lottoStore: LottoStore,
    private val incomeCalculator: IncomeCalculator,
) {
    fun issue(lottoOrder: LottoOrder): Lottos {
        return lottoStore.sell(lottoOrder)
    }

    fun getResult(
        lotto: Lottos,
        winningLotto: WinningLotto,
    ): LottoResult {
        val results = lotto.match(winningLotto)
        val incomeRate = calculateIncomeRate(lotto, results)

        return LottoResult(results, incomeRate)
    }

    private fun calculateIncomeRate(
        lotto: Lottos,
        results: Results,
    ): IncomeRate {
        val usedMoney = Money(LOTTO_PRICE * lotto.quantity)
        val prize = results.prize
        val incomeRate = incomeCalculator.calculate(usedMoney, prize)

        return incomeRate
    }
}
