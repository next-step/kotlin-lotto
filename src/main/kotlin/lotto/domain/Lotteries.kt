package lotto.domain

class Lotteries(val lotteries: List<Lottery>) {
    fun winningResult(winningNumber: Numbers): WinningResult {
        val winningResult = WinningResult()
        lotteries.forEach {
            val amountOfNumberMatched = it.numbers.amountOfNumberMatched(winningNumber)
            winningResult.recordPrize(Prize.of(amountOfNumberMatched))
        }
        return winningResult
    }

    fun size(): Int = lotteries.size

    companion object {
        fun of(money: Money): Lotteries {
            val amountOfLotteries = money.amount / Lottery.ONE_LOTTERY_PRICE.amount
            val lotteries = buildList { repeat(amountOfLotteries.toInt()) { add(Lottery()) } }
            return Lotteries(lotteries)
        }
    }
}
