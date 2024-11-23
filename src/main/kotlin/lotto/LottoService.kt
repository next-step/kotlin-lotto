package lotto

class LottoService(
    private val lottoStore: LottoStore,
    private val incomeCalculator: IncomeCalculator,
) {
    fun issue(inputMoney: Money): Lottos {
        return lottoStore.sell(inputMoney)
    }

    fun getResult(
        lotto: Lottos,
        winningNumbers: Set<LottoNumber>,
    ): LottoResult {
        val results = lotto.match(winningNumbers)
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
