package lotto

class ProfitCalculator {
    fun calculateProfit(prizeMoneyPairs: List<Pair<PrizeMoney, Int>>): Money {
        val profitMoney = Money(0)
        prizeMoneyPairs.forEach {
            profitMoney.save(it.first.countToPrizeMoney(it.second))
        }
        return profitMoney
    }
}
