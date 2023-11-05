package lotto.model


class ProfitCalculator {
    companion object {
        fun calculate(ticketPrice: Int, matchResult: List<Int>, prizeMoney: List<Int>): Double {
            val ticketCount = matchResult.filter { it != 0 }.sum();
            val sum = matchResult.foldIndexed(0) { index, acc, item -> acc + prizeMoney[index] * item }
            return sum.toDouble() / (ticketPrice * ticketCount).toDouble()
        }
    }
}
